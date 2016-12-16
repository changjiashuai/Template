# Template
Android MVP + RxJava + Dagger2 +Retrofit2 Template Code

##fragmentation

管理`Fragment`

## epoxy

`RecyclerView`更简单的管理多视图问题

## takephoto_library

系统相册，相机管理

~~~
main
	|
	--java
			|
			--io.github.changjiashuai.template
			|
			--base  		->基类
			|
			--di    		->Dagger2 注入相关
			|
			--domain		->M
			|
			--navigation  ->界面跳转
			|
			--presenter	->P
			|
			--view		->V
			|
			--widget
			|
			--App.java
			|
			--Constants.java
	|
	--res
~~~