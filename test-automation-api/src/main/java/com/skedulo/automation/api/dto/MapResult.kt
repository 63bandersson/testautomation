package com.skedulo.automation.api.dto

data class MapResult(
    val routePoints: List<LatLng>?,
    val steps: List<RouteStep>? = listOf()
)

data class LatLng(val latitude: Double, val longitude: Double)


data class RouteStep(
    val duration: RouteDuration,
    val distance: RouteDistance
)

data class RouteDistance(val text: String, val value: Int)
data class RouteDuration(val text: String, val value: Int)
