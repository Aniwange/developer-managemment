package com.vela.developermanagementservice

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.usecase.GetDeveloper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner


@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(
        classes = arrayOf(DevelopersManagementServiceApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UseCaseUnitTesting {

    @Autowired
    private val getDeveloper:GetDeveloper ? = null

      @Test
     fun shouldTestGetDeveloper() {
          //depend on the value of the object in the table
          println("testing")
          var response: DeveloperDomain? = getDeveloper?.getDeveloper(8)
          Assert.assertEquals(response?.firstName, "Justine")
          Assert.assertEquals(response?.email, "js@gmail.com")
    }

}