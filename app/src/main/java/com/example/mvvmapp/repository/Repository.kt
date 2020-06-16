package com.example.mvvmapp.repository

import com.example.mvvmapp.model.Post

class Repository {

    fun getPosts(): List<Post> {
        return listOf(
            Post(
                123,
                "Jack Lee",
                "https://cdn.pixabay.com/user/2020/06/04/19-08-56-322_250x250.jpg",
                "https://pixabay.com/get/55e0d3464d53ab14f1dc8460962136791c39dce14e507440772d7ed4964ec0_640.png",
                "Android is Google's mobile operating system, used for programming or developing digital devices",
                23
            ),
            Post(
                123,
                "Annie",
                "https://cdn.pixabay.com/user/2017/06/13/10-28-40-233_250x250.jpg",
                "https://pixabay.com/get/57e2dc424e5bad14f1dc8460962136791c39dce14e507440772d7ed4964ec0_640.jpg",
                "My random thoughts",
                2
            ),
            Post(
                123,
                "Alex",
                "https://cdn.pixabay.com/user/2019/12/21/18-41-09-325_250x250.jpg",
                "https://pixabay.com/get/52e6d5404951af14f6d1867dda793e7f1236d8e7574c704c7c2d79d1974cc65d_1920.jpg",
                "mobile operating system for developing digital devices",
                13
            )
        )
    }
}