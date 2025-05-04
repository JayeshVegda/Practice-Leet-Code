class Solution {
    
    public void fill(int[][] img, int sr, int sc, int oldColor, int newColor){
        if(sr < 0 || sc < 0 || sc >= img[0].length || sr >= img.length) return;
        if(img[sr][sc] != oldColor) return;

        if(img[sr][sc] == oldColor){
            img[sr][sc] = newColor;
        }

        fill(img, sr-1, sc, oldColor, newColor);
        fill(img, sr+1, sc, oldColor, newColor);
        fill(img, sr, sc-1, oldColor, newColor);
        fill(img, sr, sc+1, oldColor, newColor);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor) return image;
        
        fill(image, sr, sc, oldColor, newColor);
        return image;
    }
}