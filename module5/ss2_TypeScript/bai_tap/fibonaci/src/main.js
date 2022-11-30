function fibonaci(a) {
    if (a == 0)
        return 0;
    if (a == 1)
        return 1;
    return fibonaci(a - 1) + fibonaci(a - 2);
}
var count = 0;
var i = 0;
var sum = 0;
while (count <= 10) {
    console.log(fibonaci(i) + " ");
    sum += fibonaci(i);
    i++;
    count++;
}
console.log(sum);
