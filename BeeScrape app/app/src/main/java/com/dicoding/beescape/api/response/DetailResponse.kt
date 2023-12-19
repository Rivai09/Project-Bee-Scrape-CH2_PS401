package com.dicoding.beescape.api.response

import com.google.gson.annotations.SerializedName

data class DetailResponse(

	@field:SerializedName("product")
	val products: Product? = null
)

data class ItemsItems(

	@field:SerializedName("persebaranData")
	val persebaranData: String? = null,

	@field:SerializedName("itemsDetail")
	val itemsDetail: List<ItemsDetailItem?>? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("category")
	val category: String? = null
)

data class Products(

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class ItemsDetailItems(

	@field:SerializedName("productTerjual")
	val productTerjual: String? = null,

	@field:SerializedName("ketTotalProduct")
	val ketTotalProduct: String? = null,

	@field:SerializedName("sell")
	val sell: String? = null,

	@field:SerializedName("topProduct")
	val topProduct: String? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("shopName")
	val shopName: String? = null,

	@field:SerializedName("jumlahData")
	val jumlahData: Int? = null,

	@field:SerializedName("productName")
	val productName: String? = null,

	@field:SerializedName("rangeJumlahTerjual")
	val rangeJumlahTerjual: String? = null,

	@field:SerializedName("rangeHarga")
	val rangeHarga: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("jumlahMerk")
	val jumlahMerk: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("_id")
	val id: String? = null
)
