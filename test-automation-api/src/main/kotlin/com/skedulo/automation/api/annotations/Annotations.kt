package com.skedulo.automation.api.annotations

enum class AuthorizationType {
    NO_AUTH, OAUTH2, TOKEN, BEARERTOKEN
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Authorization(val auth: AuthorizationType)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class BaseUrl(val url: String)
