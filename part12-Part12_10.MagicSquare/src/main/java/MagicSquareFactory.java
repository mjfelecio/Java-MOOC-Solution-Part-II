public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here

        int row = 0;
        int col = size / 2;

        for (int num = 1; num <= size * size; num++) {
            square.placeValue(col, row, num);

            int prevRow = row;
            int prevCol = col;
            row--;
            col++;

            if (row == -1) { //if the pointer goes above the magic square, move it to the bottom
                row = size - 1;
            }

            if (col >= size) { // if the pointer goes outside to the right, move it to the left
                col = 0;
            }

            // if the nextPosition already has a number, place the nextNumber below the previous position.
            if (square.readValue(col, row) != 0) {
                row = prevRow + 1;
                col = prevCol;
            }

        }
        return square;
    }
}