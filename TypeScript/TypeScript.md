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



Unknow的注意点：

1、只能赋值给自身，或者是any类型

2、没有办法读任何属性，方法也不可以调用

3、更加安全，相对于any来说



## 3、obejct、Object、{}

Object：所有类型都可以

object：引用类型

{}：类似于第一个，但是不能对对象的自变量进行操作

```js
let a:Object =123//正确 所有的类型的集合

let a:object='123'//错误 原始类型
let b:object=123//错误 原始类型
let c:object=false//错误 原始类型

let d:object=[]//正确 引用类型
let e:obejct={}//正确 引用类型


let a:{}={name:1}//相当于new Object，但是不能做对象的自变量操作，如下操作
a.age=2

```



## 4、接口和对象类型

接口中注意的点：

1、如果接口重名了，它的字段会合并

```tsx
interface Axxsxs{
  name:string
  age:number
}

let a:Axxsxs={
  name:"小红",
  age:99
}
```

2、任意key

```tsx
interface Axxsxs{
  name:string
  age:number
  [propName:string]:any//类似键值对，[]中的为键，String类型，值为any类型，注意值，规定了什么类型，接口的类型就要全部统一为一个类型
}

let a:Axxsxs={
  name:"小红",
  age:99
}
```

3、接口的？和readonly

```tsx
interface Axxsxs{
  name:string
  age?:number
  readonly id:number
}
```

4、接口继承

```tsx
interface Axxsxs extends B{
  name:string
  age?:number
  readonly id:number
}
```

5、接口定义函数类型

```tsx
//接口
interface Fn{
  (name:string):number[]
}
//继承
const fn:Fn=funciton(name:string){
  return [1]
}
```



## 5、数组类型

arguments：arguments简单来说，就是存储函数中参数的一个局部变量（注意是非[箭头函数](https://so.csdn.net/so/search?q=箭头函数&spm=1001.2101.3001.7020)），参数按索引为属性名，如第一个参数属性名是0，第二个参数属性名是1，第三个参数熟悉名是3，如

```js
function a(){ 
    console.log(arguments[0])
    console.log(arguments[1])
    console.log(arguments[2])
    
}
 
a(1,2,3)
 
// 输出：
// 1
// 2
// 3

//但注意它是一个类数组对象，可以看到，arguments的 _proto_ 指向的是 object，所以虽然看起来跟数组很像，有索引，有length，但不是数组，只是一个类数组对象，所以本身就没有数组原型上的那一堆方法了。
//当然有时候计算需要，要转换成真实数组也可以直接用 Array.from()方法或者扩展运算符
const argsArrayFrom = Array.from(arguments);
const args = [...arguments];
```



数组：

```tsx
//数组普通类型：number[]、Array<boolean>	
let arr:number[]=[1,2,3]
let arr:Array<boolean>=[true,false]

//定义对象数组使用interface
interface X{
  name:string
  age?:number
}
let arr:X[]=[{name:"逍遥"},{name:"xiaoman",age:21}]

//二维数组
let arr:number[][] =[[1],[2],[3]]
let arr:Array<Array<number>=[[1],[2],[3]]

//大杂烩数组
let arr:any[]=[1,'1123',true,{}]

//具体使用
function a(...args:string[]){
  console.log(arguments)
  //如果先要拿到arguments这个伪数组的数据，怎么办呢，
  //如下操作肯定报错
  let a:any[]=arguments
  //下面操作正确
  let a:IArguments=arguments.callee
}
a('1','2')

//IArguments的原理
interface X{
  name:string
  age?:number
  [index:number]:any
}
```



## 6、函数扩展

 1、函数定义类型和返回值 | 箭头函数定义类型和返回值

```tsx
function add(a:number,b:number):number{
  return a+b
}
```

2、函数默认的参数 | 函数可选参数

```tsx
//函数默认的参数
function add(a:number=10,b:number=20):number{
  return a+b
}
//函数可选参数
function add(a?:number,b?:number):number{
  return a+b
}
```

3、参数是一个对象如何定义

```tsx
interface User{
  name:string
  age:number
}

function add(user:User):User{
  return user
}
```

4、函数this类型

```tsx
interface Obj{
  user:number[]
  add:(this:Obj,num:number)=>void
}
//ts 可以定义this的类型 在js中无法使用 必须是第一个参数定义this类型
let obj:Obj={
  user:[1,2,3],
  add(this:Obj,num:number){
    this.user.push(num)
  }
}
obj.add(4)
```

5、函数重载

```tsx
let user:number[]=[1,2,3]

fucniton findNum(id:number):number[]
fucniton findNum():number[]
```



## 7、联合类型、类型断言、交叉类型

```tsx
//1、联合类型
let phone:number|string=12323
//0和1转化为布尔类型
let fn=funciton(type:number|boolean):boolean{
  return !!type
}

//2、交叉类型
interface Pople{
  name:string,
  age:number
}

interface Man{
  sex:number
}

const xiaoming =(man:Pople & Man):void =>{
  console.log(man)
}

//调用
xiaoming({name:'小满',sex:1,age:200})


//3、类型断言
let fn =funciton(num:number|string):void{
  console.log((num as string).length)
  //写法：1、num as string 2、<string>num
}

```



## 8、内置对象

ES内置对象：

**`Boolean`、Number、`string`、`RegExp`、`Date`、`Error`**

```tsx
let b: Boolean = new Boolean(1)
console.log(b)
let n: Number = new Number(true)
console.log(n)
let s: String = new String('哔哩哔哩关注小满zs')
console.log(s)
let d: Date = new Date()
console.log(d)
let r: RegExp = /^1/
console.log(r)
let e: Error = new Error("error!")
console.log(e)
```

DOM对象和BOM对象

**`Document`、`HTMLElement`、`Event`、`NodeList` 等**

```js
let body: HTMLElement = document.body;
let allDiv: NodeList = document.querySelectorAll('div');
//读取div 这种需要类型断言 或者加个判断应为读不到返回null
let div:HTMLElement = document.querySelector('div') as HTMLDivElement
document.addEventListener('click', function (e: MouseEvent) {
    
});
//dom元素的映射表
interface HTMLElementTagNameMap {
    "a": HTMLAnchorElement;
    "abbr": HTMLElement;
    "address": HTMLElement;
    "applet": HTMLAppletElement;
    "area": HTMLAreaElement;
    "article": HTMLElement;
    "aside": HTMLElement;
    "audio": HTMLAudioElement;
    "b": HTMLElement;
    "base": HTMLBaseElement;
    "bdi": HTMLElement;
    "bdo": HTMLElement;
    "blockquote": HTMLQuoteElement;
    "body": HTMLBodyElement;
    "br": HTMLBRElement;
    "button": HTMLButtonElement;
    "canvas": HTMLCanvasElement;
    "caption": HTMLTableCaptionElement;
    "cite": HTMLElement;
    "code": HTMLElement;
    "col": HTMLTableColElement;
    "colgroup": HTMLTableColElement;
    "data": HTMLDataElement;
    "datalist": HTMLDataListElement;
    "dd": HTMLElement;
    "del": HTMLModElement;
    "details": HTMLDetailsElement;
    "dfn": HTMLElement;
    "dialog": HTMLDialogElement;
    "dir": HTMLDirectoryElement;
    "div": HTMLDivElement;
    "dl": HTMLDListElement;
    "dt": HTMLElement;
    "em": HTMLElement;
    "embed": HTMLEmbedElement;
    "fieldset": HTMLFieldSetElement;
    "figcaption": HTMLElement;
    "figure": HTMLElement;
    "font": HTMLFontElement;
    "footer": HTMLElement;
    "form": HTMLFormElement;
    "frame": HTMLFrameElement;
    "frameset": HTMLFrameSetElement;
    "h1": HTMLHeadingElement;
    "h2": HTMLHeadingElement;
    "h3": HTMLHeadingElement;
    "h4": HTMLHeadingElement;
    "h5": HTMLHeadingElement;
    "h6": HTMLHeadingElement;
    "head": HTMLHeadElement;
    "header": HTMLElement;
    "hgroup": HTMLElement;
    "hr": HTMLHRElement;
    "html": HTMLHtmlElement;
    "i": HTMLElement;
    "iframe": HTMLIFrameElement;
    "img": HTMLImageElement;
    "input": HTMLInputElement;
    "ins": HTMLModElement;
    "kbd": HTMLElement;
    "label": HTMLLabelElement;
    "legend": HTMLLegendElement;
    "li": HTMLLIElement;
    "link": HTMLLinkElement;
    "main": HTMLElement;
    "map": HTMLMapElement;
    "mark": HTMLElement;
    "marquee": HTMLMarqueeElement;
    "menu": HTMLMenuElement;
    "meta": HTMLMetaElement;
    "meter": HTMLMeterElement;
    "nav": HTMLElement;
    "noscript": HTMLElement;
    "object": HTMLObjectElement;
    "ol": HTMLOListElement;
    "optgroup": HTMLOptGroupElement;
    "option": HTMLOptionElement;
    "output": HTMLOutputElement;
    "p": HTMLParagraphElement;
    "param": HTMLParamElement;
    "picture": HTMLPictureElement;
    "pre": HTMLPreElement;
    "progress": HTMLProgressElement;
    "q": HTMLQuoteElement;
    "rp": HTMLElement;
    "rt": HTMLElement;
    "ruby": HTMLElement;
    "s": HTMLElement;
    "samp": HTMLElement;
    "script": HTMLScriptElement;
    "section": HTMLElement;
    "select": HTMLSelectElement;
    "slot": HTMLSlotElement;
    "small": HTMLElement;
    "source": HTMLSourceElement;
    "span": HTMLSpanElement;
    "strong": HTMLElement;
    "style": HTMLStyleElement;
    "sub": HTMLElement;
    "summary": HTMLElement;
    "sup": HTMLElement;
    "table": HTMLTableElement;
    "tbody": HTMLTableSectionElement;
    "td": HTMLTableDataCellElement;
    "template": HTMLTemplateElement;
    "textarea": HTMLTextAreaElement;
    "tfoot": HTMLTableSectionElement;
    "th": HTMLTableHeaderCellElement;
    "thead": HTMLTableSectionElement;
    "time": HTMLTimeElement;
    "title": HTMLTitleElement;
    "tr": HTMLTableRowElement;
    "track": HTMLTrackElement;
    "u": HTMLElement;
    "ul": HTMLUListElement;
    "var": HTMLElement;
    "video": HTMLVideoElement;
    "wbr": HTMLElement;
}
```

类型定义：

```tsx
let local:Storage =localStorage
let lo:Location =Location
//如果我们不指定返回的类型TS是推断不出来返回的是什么类型
//promise设置返回值为number
let promise:Promise<number>=new Promise((r)=>r(1))

let cookie:string =document.cookie

```



## 9、Class对象

ES6提供了更接近传统语言的写法，引入了Class（类）这个概念，作为对象的模板。通过class关键字，可以定义类。基本上，ES6的class可以看作只是一个语法糖，它的绝大部分功能，ES5都可以做到，新的class写法只是让对象原型的写法更加清晰、更像面向对象编程的语法而已。上面的代码用ES6的“类”改写。

1、class的基本用法，继承和类型约束 implements

```tsx
interface Options{
  el:string | HTMLElement
}

interface VueCls{
  options:Options
  inti():void
}

class Vue implements VueCls{
 		options:Options
    constructor(options:Options){
      this.options=options
    }
  init():void{
    
  }
  
}
```

标准例子class对象

```tsx
class Person{
  name:string
  age:number
  constructor(name:string,age:number){
    this.name=name
    this.age=age
  }
  run(){
    
  }
}
```

注意的点：

1、你如果了定义了变量不用 也会报错 通常是给个默认值 或者 进行赋值

2、在TypeScript是不允许直接在constructor 定义变量的 需要在constructor上面先声明



2、修饰符

private：只能在内部使用

protected：给子类和内部去使用的

public：公开的



