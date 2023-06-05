interface Len {
    length:number
 }
  
 function getLegnth<T extends Len>(arg:T) {
   return arg.length
 }
  
 getLegnth<string>('123')