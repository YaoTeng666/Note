## 1.1 let和const命令

* 变量不能重复声明

```js
let star='罗志祥';
let star='小猪'
```
* let有块级作用域

```js
{
    let girl='周扬青'
}
console.log(girl)
```

不仅仅针对花括号，例如if（）里面 ​
* 不存在变量提前

```js
console.log(song)
let song='恋爱达人'
```
* 不影响作用域链

```js
let school='abc'
function fn(){
    console.log(school)
}
```

```html
DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Titletitle>
head>
<body>
    <div>
        <div class="item" style="width: 50px;height: 50px;background-color: red">div>
        <div class="item" style="width: 50px;height: 50px;background-color: red">div>
        <div class="item" style="width: 50px;height: 50px;background-color: red">div>
    div>
    <script>
        let items=document.getElementsByClassName("item");
        for (var i=0;i<items.length;i++){
            items[i].onclick=function (){
                items[i].style.backgroundColor='pink';
            }
        }
        console.log(windows.i)

    script>
body>
html>
```

* 声明常量

```js
const A = 'abc'
```

  1. 一定要赋初始值
  2. 一般常量使用大写（潜规则）
  3. 常量的值不能修改
  4. 也具有块级作用域

```js
{
    const pyaler = 'uzi'
}
console.log(player)
```
  5. 对于数组和对象的元素修改，不算作对常量的修改

```js
const team = ['uzi','MXLG','Ming','Letme'];
team.push('Meiko');
```

## 1.2 解构赋值

ES6 允许按照一定模式从数组和对象中提取值，对变量进行赋值，这被称为解构赋值。

* 数组的解构：

```js
const F4 = ['小沈阳'，'刘能','赵四','宋小宝']
let [xiao,liu,zhao,song] = F4;
console.log(xiao)
console.log(liu)
console.log(zhao)
console.log(song)
```
* 对象的解构

```js
const zhao = {
    name : '赵本山'，
    age: '不详',
    xiaopin: function(){
        console.log("我可以演小品")
    }
}
let {name,age,xiaopin} = zhao;
console.log(name);
console.log(age);
console.log(xiaopin);
```

## 1.3 模板字符串

## 1.4 对象的简化写法

ES6允许在大括号里面，直接写入变量和函数，作为对象的属性和方法,这样的书写更加简洁

```js
let name = 'aaa';
let change = function(){
    console.log('aaa');
}

const school = {
    name,
    change,
    improve(){
        consolg.log('bbb');
    }
}
```

## 1.5 箭头函数

ES6允许使用箭头（=>）定义函数

## 1.6 函数参数默认值

ES6允许给函数参数赋值初始值

## 1.7 rest参数

ES6引入rest参数，用于获取函数的实参，用来代替arguments

```js
function date(...args){
    console.log(args);
}
date('aaa','bbb','ccc')；
```

## 1.8 扩展运算符

扩展运算符是能将数组转换为逗号分隔的参数序列

```js
const tfboys=['AA','BB','CC']
function chunwan(){
    console.log(arguments);
}
chunwan(...tfboys);
```

## 1.9 Symbol

ES6引入了一种新的原始数据类型 Symbol，表示独一无二的值。它是JavaScript语言的第七种数据类型，是一种类似于字符串的数据类型。

Symbol特点：

* Symbol的值是唯一的，用来解决命名冲突的问题
* Symbol值不能与其他数据进行运算
* Symbol定义的对象属性不能使用for...in循环遍历，但是可以使用Reflect.ownKeys来获取对象的所有键名

## 1.10 迭代器

```js
const xiyou=['AA','BB','CC','DD'];

let iterator = xiyou[Symbol.iterator]();
console.log(iterator.next());
console.log(iterator.next());
```

```js
const banji = {
    name : "终极一班",
    stus: [
        'aa',
        'bb',
        'cc',
        'dd'
    ],
    [Symbol.iterator](){
        let index = 0;
        let _this = this;
        return {
            next: () => {
                if(index < this.stus.length){
                    const result = {value: _this.stus[index],done: false};

                    index++;

                    return result;
                }else {
                    return {value: underfined,done:true};
                }
            }
        }
    }
}
for(let v of banji){
    console.log(v);
}
```

## 1.11 生成器

生成器函数是ES6提供的一种异步编程解决方案，语法行为与传统函数完全不同，是一种特殊的函数

```js
function * gen (){
    yield '耳朵'；
    yield '尾巴'；
    yield '真奇怪'；
}
let iterator = gen();
console.log(iteretor.next());

console.log(iteretor.next());
console.log(iteretor.next());
```

## 1.12 Promise

Promise是ES6引入的异步编程的新解决方案。语法上 Promise是一个构造函数，用来封装异步操作并可以获取其成功或失败的结果。

> 应用：发送AJAX请求

```js
<script>

    function sendAjax(url){
        return new Promise((resolve, reject) => {

            const x =new XMLHttpRequest();

            x.open('GET',url);

            x.send();

            x.onreadystatechange = ()=>{
                if(x.readyState === 4 ){
                    if(x.status >= 200 && x.status < 300){

                        resolve(x.response)
                    }else {

                        reject(x.status)
                    }
                }
            }
        })
    }

    sendAjax("https://api.apiopen.top/getJoke").then(value => {
        console.log(value)
    },reason => {
		console.log(reason)
    })

</script>
```

### promise读取文件

```js
const fs =require('fs')

const p = new Promise(function (resolve, reject) {
  fs.readFile("./resources/测试.md", (err, data) => {
    if (err) reject(err);
    //如果成功
    resolve(data);
  });
});

p.then(funciton(value){
	console.log(value.toString())     
},funciton(reason){
    console.log("读取失败")
})
```

### then回调函数

调用then方法	then方法的返回交过是promise对象，对象状态由回调函数结果决定。

1、如果回调函数中返回的结果是非promise类型的属性，状态为成功，返回为对象的成功

```js
const result =p.then(value=>{
    console.log(value)
    //1.非promise类型的属性
    return "dd"
    //2.是promise对象
    return new Promise((resolve,reject)=>{
        resolve('ok')
    })
    //3.抛出异常
    throw '出错了'
})
```

### 链式写法

```js
p.then(value=>{

}).then(value=>{

},reason=>{

})
```



### 回调地狱对比Promise实现

```js

const fs =require("fs")


//回调地狱
fs.readFile('./test01.md',(err,data1)=>{
    fs.readFile('./test02.md',(err,data2)=>{
        fs.readFile('./test03.md',(err,data3)=>{
            let result =data1+data2+data3
            console.log(result)
            
        })
    })
})

//Promise使用
const p =new Promise((resolve,reject)=>{
    fs.readFile("./test01.md",(err,data)=>{
        resolve(data)
    })
})

p.then(value=>{
    return new Promise((resolve, reject) => {
        fs.readFile("./test02.md",(err,data)=>{
            resolve([value,data])
        })
    })
}).then(value=>{
    return new Promise((resolve, reject) => {
        fs.readFile("./test03.md",(err,data)=>{
            value.push(data)
            resolve(value)
        })
    })
}).then(value=>{
    console.log(value.join('\r\n'))
})
```

### catch

```js
p.catch(funciton(reason){
	console.warn(reason)
})
```



## 1.13 集合

ES6提供了新的数据结构set(集合）。它类似于数组，但成员的值都是唯一的，集合实现了iterator接口，所以可以使用「扩展运算符』和「 for...of...』进行遍历，集合的属性和方法:

* size返回集合的元素个数
* add增加一个新元素，返回当前集合
* delete删除元素，返回boolean值has检测集合中是否包含某个元素，返回boolean值

```js
<script>
    let s = new Set();
    let s2 = new Set(['A','B','C','D'])
	//集合个数
    console.log(s2.size);
	//添加元素
    s2.add('E');
	//删除元素
    s2.delete('A')
	//监测是否存在某个值
    console.log(s2.has('C'));
	//清空数组
    s2.clear()

    console.log(s2);
</script>
```

```js
<script>
    let arr = [1,2,3,4,5,4,3,2,1]
	//数组去重
    let result = [...new Set(arr)]
    console.log(result);
	//交集
    let arr2=[4,5,6,5,6]
    let result2 = [...new Set(arr)].filter(item => new Set(arr2).has(item))
    console.log(result2);
	//并集
    let result3=[new Set([...arr,...arr2])]
    console.log(result3);
	//差集
    let result4= [...new Set(arr)].filter(item => !(new Set(arr2).has(item)))
    console.log(result4);

</script>
```

ES6提供了Map数据结构。它类似于对象，也是键值对的集合。但是"键"的范围不限于字符串，各种类型的值（包括对象）都可以当作键。Map也实现了iterator接口，所以可以使用『扩展运算符』和「for...of...』进行遍历。Map的属性和方法。

```js
<script>
    let m = new Map();
    m.set('name','ran');
    m.set('change',()=>{
        console.log('改变！')
    })
    let key={
        school:'atguigu'
    }
    m.set(key,['成都','西安']);

    console.log(m.size);

    m.delete('name');

    console.log(m.get('change'));

    for(let v of m){
        console.log(v);
    }
</script>
```

## 1.14 Class

ES6提供了更接近传统语言的写法，引入了Class（类）这个概念，作为对象的模板。通过class关键字，可以定义类。基本上，ES6的class可以看作只是一个语法糖，它的绝大部分功能，ES5都可以做到，新的class写法只是让对象原型的写法更加清晰、更像面向对象编程的语法而已。

```js
<script>
    class shouji {
        constructor(brand,price) {
            this.brand=brand;
            this.price=price
        }

        call(){
            console.log('我可以打电话')
        }
    }

    let A = new shouji('1+',1999);
    console.log(A)
</script>
```

```js
<script>
  class Person{
      static name='手机'
  }
  let nokia = new Person();
  console.log(nokia.name);
</script>
```

```js
<script>
  function Phone(brand,price){
      this.brand=brand;
      this.price=price;
  }
  Phone.prototype.call=function (){
      console.log("我可以打电话");
  }
  function SmartPhone(brand,price,color,size){
      Phone.call(this,brand,price);
      this.color=color;
      this.size=size;
  }

  SmartPhone.prototype=new Phone;
  SmartPhone.prototype.constructor=SmartPhone;

  SmartPhone.prototype.photo = function (){
      console.log('我可以玩游戏');
  }
  const chuizi = new SmartPhone('锤子',2499,'黑色','5.5inch')
  console.log(chuizi);
</script>
```

```js
<script>
    class Phone{
        constructor(brand,price) {
            this.brand=brand;
            this.price=price;

        }

        call(){
            console.log('我可以打电话')
        }
    }
    class SmartPhone extends Phone{
        constructor(brand,price,color,size) {
            super(brand,price);
            this.color=color;
            this.size=size;
        }
        photo(){
            console.log('拍照');
        }

        playGame(){
            console.log('打游戏');
        }
    }
    const xiaomi=new SmartPhone('小米',1999,'黑色','4.7inch')
    xiaomi.call();
    xiaomi.photo();
    xiaomi.playGame();
</script>
```

```js
<script>
    class Phone{
        constructor(brand,price) {
            this.brand=brand;
            this.price=price;

        }

        call(){
            console.log('我可以打电话')
        }
    }
    class SmartPhone extends Phone{
        constructor(brand,price,color,size) {
            super(brand,price);
            this.color=color;
            this.size=size;
        }
        photo(){
            console.log('拍照');
        }

        playGame(){
            console.log('打游戏');
        }

        call(){
            console.log('我可以进行视频通话')
        }
    }
    const xiaomi=new SmartPhone('小米',1999,'黑色','4.7inch')
    xiaomi.call();
    xiaomi.photo();
    xiaomi.playGame();
</script>
```

class中的getter和setter的使用

```js
<script>
  class Phone{
      get price(){
          console.log("价格被读取了")
          return 'I LOVE YOU'
      }

      set price(val){
          console.log('价格被修改了')
          return val;
      }
  }

    let s = new Phone();
    s.price=12

</script>
```

## 1.15 数值扩展

```js
<script>

   function equal(a,b){
       if(Math.abs(a-b) < Number.EPSILON){
           return true;
       }else {
           return false;
       }
   }

   console.log(equal(0.1 + 0.2 === 0.3))
   console.log(equal(0.1+0.2,0.3))
   //1、二进制和八进制
   let b = 0b1010;
   let o = 0o777;
   let d = 100;
   let x = 0xff;
   console.log(x)
  //2、检测一个数值是否为有限数
   console.log(Number.isFinite(100));
   console.log(Number.isFinite(100/0));
   console.log(Number.isFinite(Infinity));

   console.log(Number.isNaN(123))

   console.log(Number.parseInt('5213123love'));
   console.log(Number.parseFloat('5.123123神器'));
   //是否为一个整数
   console.log(Number.isInteger(5));
   console.log(Number.isInteger(2.5));
  //去除小数部分抹掉
   console.log(Math.trunc(3.45345345345))
  //判断是否为正数、负数、零
   console.log(Math.sign(100))
   console.log(Math.sign(0))
   console.log(Math.sign(-123))
</script>
```

## 1.16 对象方法扩展

```js
<script>
	//判断二个值是否完全相等
    console.log(Object.is(120,120))
	console.log(Object.is(NaN,NaN))
	//合并对象
    const a = {
        name:'ran',
        age:12
    }
    const b = {
        pass:'i love you'
    }
    console.log(Object.assign(a,b))
	//设置原型对象
    const school = {
        name:'尚硅谷'
    }
    const cities = {
        xiaoqu:['北京','上海']
    }
    Object.setPrototypeOf(school,cities)
    console.log(Object.getPrototypeOf(school))
    console.log(school)
</script>
```

## 1.17 模块化  三种引入导出方法

1.export default默认暴露，对应import...from...默认导入

export default用于默认导出一个模块，在导入时可以使用import obj from 'module'的语法直接导入默认导出的内容，并将其绑定到变量obj上。

2.export ...export...分别暴露对应import {} from ...按需引入

export ...用于按需导出一个或多个模块，在导入时需要使用花括号指定导入的模块名称，例如import { a, b } from 'module'。

3.export {，，}统一暴露对应import * as ... from ...（也可以用import {} from ...导入）

export { ...}用于统一导出一个或多个模块，并在导入时使用import * as obj from 'module'的语法将所有导出的模块绑定到一个对象上。也可以在导入时使用花括号指定部分导出的模块名称，例如import { a, b } from 'module'。

值得注意的是，三种暴露和引入的方法是对应的关系。而export {，，}可以当成是多个export ...语句合并到一起，用于统一导出一个或多个模块，所以在导入时可以使用按需导入的方式，即使用花括号来指定需要导入的变量、函数或类的名称。

```js
//结构赋值形式
import {school,teach} from "./js/m1.js"
import {school as guigu,teach} from "./js/m2.js"
import {default as m3} from "./js/m3.js"

//简便形式 只针对于默认暴露
import m3 from "./js/m3.js"
```

模块功能主要有两个命令构成：export和import

* export命令用于规定模块的对外接口
* import命令用于输入其他模块提供的功能

```js
export let school = '尚硅谷'
export function teach(){
    console.log('教技能')
}
```

```js
//html中第一种引用
<script type="module">
    import * as m1 from "./src/js/m1.js";
	console.log(m1);
</script
```

```js
//html中第二种引用 app.js做汇总
<script src="./src//js/app.js" type=modeule></script>
//app.js会写
import * as m1 from 'js/m1.js'
```

```js
<script>

   const mingzhu = ['西游记','红楼梦','水浒传','三国演义']
   console.log(mingzhu.includes('西游记'))
   console.log(mingzhu.includes('金瓶梅'))

    console.log(2**10)
</script>
```

相关语法

```js
//默认暴露
export default{
    
}
//语法1
export {变量1,方法1}

//语法2
export let schoole ='变量'
```

## 2.es6代码打包为ES5

可以使不支持es6的浏览器都可以运行代码

1、使用babel打包——babel-cli、babel-preset-env、browserify(webpack)

2、npx babel src/js -d dist/js

3、打包 npx browserify dist/js/app.js -o dist/bundle.js

## 2.0 ES7 新特性 includes

>介绍

1. Array.prototype.includes：用来检测数组中是否包含某个元素，返回布尔类型值 
2. 在ES7中引入指数操作符**，用来实现幂运算，功能与Math.pow结果相同

>应用

```java
<script>
    //include
   const mingzhu = ['西游记','红楼梦','水浒传','三国演义']
   console.log(mingzhu.includes('西游记'))  //true
   console.log(mingzhu.includes('金瓶梅'))  //false

    //** 和math.pow(2,10)一样
    console.log(2**10) // 1024
</script>
```





## 3.1 async函数

async和await两种语法结合可以让异步代码像同步代码一样

async函数：

* async函数的返回值为promise对象
* async返回的promise对象的结果值由async函数执行的返回值决定

```js
async function fn(){
   
   //1.如果返回的是一个非Promise的对象，则fn（）返回的结果就是成功状态的Promise对象，值为返回值
   //2.如果返回的是一个Promise对象，则fn（）返回的结果与内部Promise对象的结果一致
   //3.如果返回的是抛出错误，则fn（）返回的就是失败状态的Promise对象
   return new Promise((resolve,reject)=>{
 
       resolve('成功的数据');
   });
}
const result = fn();
result.then(value=>{
   
   console.log(value)  //成功的数据
},reason=>{
   
   console.log(reason)
})
```







## 3.2 await表达式

1. await必须写在async函数中
2. await右侧的表达式一般为promise对象
3. await返回的是promise成功的值
4. await的promise失败了，就会抛出异常，需要通过try...catch捕获处理

```js
<script>
    //创建Promise对象
    const p = new Promise((resolve, reject) => {
   
        // resolve("成功的值")
        reject("失败了")
    })

    //await 必须放在async函数中
    async function main() {
   
        try {
   
            let res = await p;
            console.log(res);
        } catch (e) {
   
            console.log(e);
        }
    }

    //调用函数
    main()  //失败了
</script>
```



同步执行代码

```js
function a1(){
    return new Promise((resolve, reject) => {
        resolve("1") 
    })
}
function a2(){
    return new Promise((resolve, reject) => {
        resolve("2") 
    })
}
function a3(){
    return new Promise((resolve, reject) => {
        resolve("3") 
    })
}

async function main(){
    let a1 =await a1();
    let a2 =await a2();
    let a3 =await a3();
    console.log("同步执行代码")
}
```



> 应用：发送AJAX请求

```js
<script>
    //ajax请求返回一个promise
    function sendAjax(url){
   
        return new Promise((resolve, reject) => {
   

            //创建对象
            const x =new XMLHttpRequest();

            //初始化
            x.open('GET',url);

            //发送
            x.send();

            //时间绑定
            x.onreadystatechange = ()=>{
   
                if(x.readyState === 4 ){
   
                    if(x.status >= 200 && x.status < 300){
   
                        //成功
                        resolve(x.response)
                    }else {
   
                        //失败
                        reject(x.status)
                    }
                }
            }
        })
    }

   //async 与 await 测试
    async function main(){
   
        let result = await sendAjax("https://api.apiopen.top/getJoke")
        console.log(result);
    }
    main()

</script>
```



## 3.3 ES8对象方法扩展

```java
<script>
    const school = {
   
        name:'尚硅谷',
        cities:['北京','上海','深圳'],
        xueke:['前端','Java','大数据','运维']
    };

    //获取对象所有的键
    console.log(Object.keys(school));

    //获取对象所有的值
    console.log(Object.values(school));

    //entries,用来创建map
    console.log(Object.entries(school));
    console.log(new Map(Object.entries(school)))

    //对象属性的描述对象
    console.log(Object.getOwnPropertyDescriptor(school))
    
    const obj = Object.create(null,{
   
        name:{
   
            value:'尚硅谷',
            //属性特性
            writable:true,
            configurable:true,
            enumerable:true,
        }
    })
</script>
```





## 4.1 ES9中运算扩展符与rest参数

rest参数与spread扩展运算符在ES6中已经引用，不过es6中只针对数组，

在es9中为对象提供了像数组一样的rest参数和扩展运算符

```java
<script>
    function connect({host,port,...user}){
   
        console.log(host);
        console.log(port);
        console.log(user)
    }
    connect({
   
        host:'127.0.0.1',
        port:3306,
        username:'root',
        password:'root',
        type:'master'
    })  //127.0.0.1  3306  {username: "root", password: "root", type: "master"}

</script>
```

```java
<script>
    const AA={
   
        username:'ran'
    }
    const BB={
   
        password:'lyyrhf'
    }
    const CC={
   
        job:'Java'
    }
    const D={
   ...AA,...BB,...CC};
    console.log(D) //{username: "ran", password: "lyyrhf", job: "Java"}
</script>
```





## 5.1 对象扩展方法

```java
<script>
   //二维数组
   const res = Object.fromEntries([
       ['name','RHF'],
       ['cities','成都','武汉']
   ])
   console.log(res) //{name: "RHF", cities: "成都"}

   //Map
   const m = new Map();
   m.set('name','ranhaifeng')
   const result = Object.fromEntries(m)
   console.log(result); //{name: "ranhaifeng"}
</script>
```




## 5.2 字符串扩展方法

```java
<script>
   //trim
   let str= ' asd  '
   console.log(str) //asd
   console.log(str.trimStart()) //asd  清空头空格
   console.log(str.trimEnd()) //  asd  清空尾空格
</script>
```




## 5.3 flat与flatMap

```java
<script>
    const arr = [1,2,3,[4,5,6,[7,8,9]]]
    //参数为深度，是一个数字
    console.log(arr.flat(2)) //[1,2,3,4,5,6,7,8,9]

	const arr2=[1,2,3,4]
    const result = arr2.flatmap(item => [item * 10]); //如果map的结果是一个多维数组可以进行flat 是两个操作的结合
	
</script>
```




## 5.4 Symbol的description

>介绍

用来获取Symbol的字符串描述

>实例

```java
let s = Symbol('尚硅谷');
console.log(s.description) //尚硅谷
```




## 5.5 私有属性

```java
<script>
    class Person {
   
        //公有属性
        name;
        //私有属性
        #age;
        #weight;

        //构造方法
        constructor(name, age, weight) {
   
            this.name = name;
            this.#age = age;
            this.#weight = weight;
        }
        intro(){
   
            console.log(this.name);
            console.log(this.#age);
            console.log(this.#weight);
        }
    }

    //实例化
    const girl = new Person('陈', 18, '45kg');
    console.log(girl.#age) //error
    console.log(girl); //Person{name: "陈", #age: 18, #weight: "45kg"}
    girl.intro(); // 陈 18  45kg
</script>
```




## 5.6 Promise

```java
<script>
    //声明两个promise对象
    const p1 = new Promise((resolve, reject) => {
   
        setTimeout(()=>{
   
            resolve('商品数据-1')
        },1000)
    })

    const p2 = new Promise((resolve, reject) => {
   
        setTimeout(()=>{
   
            reject('出错了！')
        },1000)
    })

    //调用allsettled方法:返回的结果始终是一个成功的，并且异步任务的结果和状态都存在
    const res = Promise.allSettled([p1,p2]);
    console.log(res)

    // Promise {<pending>}
    //     __proto__: Promise
    //     [[PromiseState]]: "fulfilled"
    //     [[PromiseResult]]: Array(2)

    //调用all方法：返回的结果是按照p1、p2的状态来的，如果都成功，则成功，如果一个失败，则失败，失败的结果是失败的Promise的结果
    const result = Promise.all([p1,p2])
    console.log(result)

</script>
```




## 5.7 可选链操作符

```java
//相当于一个判断符，如果前面的有，就进入下一层级
function main(config){
   
    const dbHost = config?.db?.host
    console.log(dbHost) //192.168.1.100
}

main({
   
    db:{
   
        host:'192.168.1.100',
        username:'root'
    },
    cache：{
   
    	host:'192.168.1.200',
    	username:'admin'
	}
})
```




## 5.8 动态import

```java
btn.onclick = function(){
   
    //使用之前并未引入，动态引入，返回的其实是一个Promise对象
    import('./hello.js').then(module=>{
   
        module.hello();
    })
}
```




## 5.9 BigInt类型

```java
//大整型
let n = 521n;
console.log(n,typeof(n))  // 521n  n 

//函数
let n = 123;
console.log(BigInt(n)) // 123n  //不要使用浮点型，只能用int

//大数值运算
let max = Number.MAX_SAFE_INTEGER; // 9007199254740991
console.log(max +1) // 9007199254740992
console.log(max +2) // 9007199254740992 出问题了
console.log(BigInt(max)+BigInt(1)) 9007199254740992n
console.log(BigInt(max)+BigInt(2)) 9007199254740993n
```




## 5.10 绝对全局对象globalThis

```java
console.log(globalThis) //window  //适用于复杂环境下直接操作window
```



## 

