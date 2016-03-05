var grid = [
    1, 2, 3,
    4, 5, 6,
    7, 8, 9
];

document.getElementById('btn5').onclick = function(e) {
    var len = Math.sqrt(grid.length);
    var rotatedGrid = [];
    rotatedGrid.length = grid.length;

    for (var i = 0; i < grid.length; i++) {
        var x = i % len;
        var y = Math.floor(i / len);

        if (y == 0) {
            if (++x >= len) {
                x = len - 1;
                y++;
            }
        }
        else if (y == 1) {
            if (x == 0) y--;
            if (x == 2) y++;
        }
        else if (y == 2) {
            if (--x < 0) {
                x = 0;
                y--;
            }
        }

        rotatedGrid[y * len + x] = grid[i];
    }
    grid = rotatedGrid;

    var i = 1;
    grid.forEach(function(cell) {
        document.getElementById('btn' + i).textContent = cell[i - 1];
        i++;
    })
}