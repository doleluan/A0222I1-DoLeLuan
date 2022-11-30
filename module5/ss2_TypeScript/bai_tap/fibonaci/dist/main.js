function fibonaci(a) {
    if (a == 0 || a == 1)
        return 1;
    return fibonaci(a - 1) + fibonaci(a - 2);
}
let count = 0;
let i = 0;
let sum = 0;
while (count <= 10) {
    console.log(fibonaci(i) + " ");
    sum += fibonaci(i);
    i++;
    count++;
}
console.log(sum);
//# sourceMappingURL=main.js.map