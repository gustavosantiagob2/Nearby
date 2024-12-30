package com.example.nearby.ui.util

import com.google.android.gms.maps.model.LatLng

fun findSouthWestPoint(points: List<LatLng>): LatLng {
    if (points.isEmpty()) return LatLng(0.0, 0.0)

    var southWestPoint = points[0]

    for (point in points) {
        if (
            point.latitude < southWestPoint.latitude
            ||
            (point.latitude == southWestPoint.latitude && point.longitude < southWestPoint.longitude)
        ) {
            southWestPoint = point
        }
    }
    return southWestPoint
}

fun findNortheastPoint(points: List<LatLng>): LatLng {
    if (points.isEmpty()) return LatLng(0.0, 0.0)

    var northeastPoint = points[0]

    for (point in points) {
        if (
            point.latitude > northeastPoint.latitude
            ||
            (point.latitude == northeastPoint.latitude && point.longitude > northeastPoint.longitude)
        ) {
            northeastPoint = point
        }
    }
    return northeastPoint
}