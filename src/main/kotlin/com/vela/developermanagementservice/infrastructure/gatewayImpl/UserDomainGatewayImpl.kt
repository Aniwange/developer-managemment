package com.vela.developermanagementservice.infrastructure.gatewayImpl


import com.vela.developermanagementservice.domain.UserDomain
import com.vela.developermanagementservice.domain.domaingateway.UserDomainGateway
import com.vela.developermanagementservice.domain.dto.RegisterUserCommand
import com.vela.developermanagementservice.infrastructure.exception.BadArgumentException
import com.vela.developermanagementservice.infrastructure.persistence.entities.UserDbEntity
import com.vela.developermanagementservice.infrastructure.persistence.repository.PrivilegesDbEntityRepo
import com.vela.developermanagementservice.infrastructure.persistence.repository.UserDbEntityRepository
import com.vela.learnkoltlin.domain.dto.LoginResponseCommand
import org.apache.commons.codec.binary.Base64
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder
import javax.inject.Named

@Named
class UserDomainGatewayImpl(val repo: UserDbEntityRepository, val privilegesDbEntityRepo: PrivilegesDbEntityRepo) : UserDomainGateway {
    override fun loginUser(email: String, password: String): LoginResponseCommand {
        val url = URL("http://localhost:9000/oauth/token")
        try {
            val conn = url.openConnection() as HttpURLConnection
            val authorization = getCredentials()
            println("authorization 1: $authorization")
            conn.doOutput = true
            conn.requestMethod = "POST"
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
            conn.setRequestProperty("Authorization", authorization)
            var input = "grant_type=" + URLEncoder.encode("password") +
                    "&username=" + URLEncoder.encode(email) +
                    "&password=" + URLEncoder.encode(password)
            println("Request data: $input")
            var os = conn.outputStream
            os.write(input.toByteArray())
            os.flush()
            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                val reader = BufferedReader(InputStreamReader(conn.inputStream))
                val generatedToken = reader.readLine().toString();
                val response = LoginResponseCommand(generatedToken);
                reader.close();
                return response;
            }
            if (conn.responseCode != HttpURLConnection.HTTP_OK) {
                var reader = BufferedReader(InputStreamReader(conn.errorStream))
                val generatedToken = reader.readLine().toString();
                val response = LoginResponseCommand(generatedToken);
                reader.close();
                return response;
            }
        } catch (e: MalformedURLException) {

            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()

        }finally {

        }

        return LoginResponseCommand("something went wrong")


    }
    private fun getCredentials(): String {
        val plainClientCredentials = "user" + ":" + "userSignKey"
        val base64ClientCredentials = String(Base64.encodeBase64(plainClientCredentials.toByteArray()))
        return "Basic $base64ClientCredentials"
    }
    @Autowired
    internal var bCryptPasswordEncoder: BCryptPasswordEncoder? = null

    override fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain {
         var   privilegeDbEntity = privilegesDbEntityRepo.getOne(4)

         if(registerUserCommand.role.name =="USER"){
                  privilegeDbEntity = privilegesDbEntityRepo.getOne(5)
                }

         val  password = bCryptPasswordEncoder!!.encode(registerUserCommand.password)

         var userDbEntity1: UserDbEntity? = checkUserExistence(registerUserCommand)

        if(userDbEntity1 != null){
            throw BadArgumentException("User already exist")
        }

        val  userDbEntity = UserDbEntity(
               firstName = registerUserCommand.firstName,
                email = registerUserCommand.email,
                middleName = registerUserCommand.middleName,
                lastName = registerUserCommand.lastName,
                password = password,
                role = registerUserCommand.role,
                privilege = privilegeDbEntity)
         repo.save(userDbEntity)

        return UserDomain(userDbEntity.id, userDbEntity.firstName, userDbEntity.middleName, userDbEntity.lastName, userDbEntity.email, userDbEntity.role.name)
    }

    private fun checkUserExistence(registerUserCommand: RegisterUserCommand): UserDbEntity? {
        var userDbEntity1: UserDbEntity? = try {

            repo.findByEmail(registerUserCommand.email)

        } catch (e: EmptyResultDataAccessException) {

            null
        }
        return userDbEntity1
    }
    /** 1.  run this bean to create privileges */

//    @Bean
//    private fun createMyPrivileges() {
//        val privilegeDbEntityList = privilegesDbEntityRepo.findAll()
//        if (privilegeDbEntityList.size < 3) {
//            val createAdminPrivilegeRequest1 = PrivilegeDbEntity("Admin-privilege")
//            //createAdminPrivilegeRequest1.setCreatedDate(LocalDate.now())
//            val createUserPrivilegeRequest2 = PrivilegeDbEntity("User-privilege")
//            //createUserPrivilegeRequest2.setCreatedDate(LocalDate.now())
//            val createUserPrivilegeRequest3 = PrivilegeDbEntity("SuperAdmin-privilege")
//            //createUserPrivilegeRequest3.setCreatedDate(LocalDate.now())
//            val privilegeDbEntities = ArrayList<PrivilegeDbEntity>()
//            privilegeDbEntities.add(createAdminPrivilegeRequest1)
//            privilegeDbEntities.add(createUserPrivilegeRequest2)
//            privilegeDbEntities.add(createUserPrivilegeRequest3)
//            for (privilege in privilegeDbEntities) {
//                privilegesDbEntityRepo.save(privilege)
//            }
//
//        }
    //}

/** after doing 1 above :  run this bean to create admin seed user */


//    @Bean
//    private fun createSeedUser(): String? {
//        val password = bCryptPasswordEncoder!!.encode("password")
//
//        var  userDbEntity = UserDbEntity(
//                firstName = "Tertese",
//                email = "terteseamos@gmail.com",
//                middleName = "Amos",
//                lastName = "Aniwange",
//                password = password,
//                role = Role.ADMIN,
//                privilege = privilegesDbEntityRepo.getOne(4)
//        )
//            repo.save(userDbEntity)
//            return "created"
//
//        }

}