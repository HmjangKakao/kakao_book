package com.hmjang.kakaobook.ui.base

import androidx.lifecycle.LiveData

@Suppress("UNCHECKED_CAST")
class SafeMutableLiveData<T> : LiveData<T> {

    constructor(value: T) : super(value)
    constructor() : super()

    override fun getValue(): T = super.getValue() as T
    public override fun setValue(value: T) = super.setValue(value)
    public override fun postValue(value: T) = super.postValue(value)

}