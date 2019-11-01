package com.vela.developermanagementservice


//@RunWith(MockitoJUnitRunner::class)
class UseCaseUnitTesting {

//    @MockBean
//    private lateinit var getDeveloper:GetDeveloper
//
//      @Test
//     fun shouldTestGetDeveloper() {
//          //depend on the value of the object in the table
//          println("testing")
//          var response: DeveloperDomain? = getDeveloper.getDeveloper(8)
//          Assert.assertEquals(response?.firstName, "Justine")
//          Assert.assertEquals(response?.email, "js@gmail.com")
//    }

//    var mockMvc: MockMvc? = null
//
//    @Mock
//    lateinit var loginService: LoginService
//
//    @BeforeEach
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        val controller = LoginController(loginService)
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
//
//    }
//
//    @Test
//    fun processLogin() {
//        val token = "testtoken"
//        val loginData = LoginRequest("test@gmail.com","testtest", "123451234")
//        Mockito.`when`(loginService.processLogin(loginData)).thenReturn(LoginResponse(AppUserCommand("",""), token))
//        val requestString = AppUtil.toJsonString(loginData);
//        val result: MvcResult = mockMvc!!.perform(MockMvcRequestBuilders.post("/v1/api/app/auth/login")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(requestString).header("client-key", "testtest"))
//                .andExpect(MockMvcResultMatchers.status().isOk)
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.token", Matchers.`is`(token)))
//                .andReturn()
//        val content = result.response.contentAsString;
//        Mockito.verify(loginService, Mockito.times(1)).processLogin(loginData)
//    }


}