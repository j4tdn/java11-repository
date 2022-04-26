//Inheritance & Composition
Array.prototype.add = function(index, element){
 	this.splice(index, 0, element);
 };


let months = ['MAR', 'APR', 'MAY', 'JUNE'];

// add
months.unshift('FEB'); // unshift(item) = add(0, item)
// expected: ---> ['FEB', 'MAR', 'APR', 'MAY', 'JUNE']

months.push('AUG'); // push(item) = add(length-1, item)
// expected ---> ['FEB', 'MAR', 'APR', 'MAY', 'JUNE', 'AUG']

//months.splice(5, 0, 'JULY', 'JULY123') // splice(index, delecteCount, items)
months.add(5, 'JULY');
// deleteCount = 0 => add
// deleteCount >0 => remove
// splice(index, 0, item) = addAll(index, item)

// remove

// replace

 console.log(months);

 