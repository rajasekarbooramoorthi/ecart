package com.cart.ecart.domain.model

data class Cart(
    val createdAt: String?,
    val name: String?,
    val avatar: String?,
    val email: String,
    val raja: List<String?>?,
    val id: String?
)