package com.moejehad.unitonetask.domain.use_case

data class SignInResult(
    val successful: Boolean = false,
    val mobileError: String = "",
)
