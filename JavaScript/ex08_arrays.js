// Inheritance & Composition
Array.prototype.add = function(index, element) {
	this.splice(index, 0, element);
};
let months = ['MAR', 'APR', 'MAY', 'JUNE'];

// add
months.unshift('FEB'); // unshift(item) = add(0, item)
// expected ---> ['FEB', 'MAR', 'APR', 'MAY', 'JUNE'] 

months.push('AUG'); // push(item) = add(length-1, item);
// expected ---> ['FEB', 'MAR', 'APR', 'MAY', 'JUNE', 'AUG']

// months.splice(5, 0, 'JULY'); // splice(index, deleteCount, items)
months.add(5, 'JULY');
// deleteCount = 0 ==> add
// deleteCount > 0 ==> remove
// splce(index, 0, items) = addAll(index, items);

// remove

// replace

console.log(months);