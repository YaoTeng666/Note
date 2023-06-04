# TypeScript

## 

## 1、基础类型

tsc -w 编译ts文件到js

```js
let str:string='小满'//string类型
let num:number=123//数字类型
let b1:boolean=true//bool类型

let infinityNumber:number =Infinity //无穷大
let decimal:number=6//十进制
let hex:number=0xf00d;//十六进制
let binary:number=0b1010;//二进制
let octal:number=0o744;//八进制

let n:null=null 
let b:undefined=undefined 

let v1:void =null// 严格类型下为的，strict的false，不报错，前提是你得执行tsc --init
let a:undefined =undefinded //严格类型下为的，strict的false，不报错，前提是你得执行tsc --init

//void！！
function myFn():void{
  return 123//报错
}


```

 

## 2、任意类型

类型排行：

1、Top Type 顶级类型 any unknown

2、Object

3、Number、String、Boolean

4、number、string、boolean

5、never

