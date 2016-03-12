/*
 * Complete the function below.
 */

var mod = 1000000007;
var m = new Array(25);
for (i = 0; i < 25; i++) m[i] = new Array(25);

function iter(a,b) {
    if (m[a][b] > 0) return m[a][b];

    if ((a == 0) || (b == 0)) {
        m[a][b] = 1;
        return 1;
    }

    m[a][b] = (iter(a, b - 1) + iter(a - 1, b)) % mod;
    return m[a][b];
}

function p(a,b) {
    if (b == 0) return 1;
    r = p(a, b/2);
    r = (r * r) % mod;
    if (b % 2) r = (r * a) % mod;
    return r;
}

function volleyball(A, B) {
    if ((A < 25) && (B < 25)) return 0;
    iter(24,24);

    var a = Math.min(A,B);
    var b = Math.max(A,B);

    var w = a;
    var l = b;
    if (a < b) {
        w = b;
        l = a;
    }
    if ((w == l) || ((w - l) == 1)) return 0;
    if ((w > 25) && (l < 24)) return 0;
    if ((l == 24) && ((w - l) > 2)) return 0;
    if ((w >= 25) && (l >= 25) && ((w - l) > 2)) return 0;

    var d = Math.max(w, l) - 24;
    var mw = Math.min(w, 24);
    var ml = Math.min(l, 24);

    var r = iter(mw, ml);
    if (w <= 25) return r;

    r = (r * pow(2, d - 2)) % mod;

    return r;
}

console.log(volleyball(3,25));
