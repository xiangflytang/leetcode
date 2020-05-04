package com.graph;

public class NumberOfIsland {
	// 思路，便利整个图， 只看每个点的右下角， 如果和别的点（岛）相连，
	// 则Union ,然后把改点标为0
	public static void main(String[] args) {
		char[][]grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		char[][] grid1= {};
		NumberOfIsland island = new NumberOfIsland();
		System.out.println(island.numIslands(grid1));
	}
	public int numIslands(char[][] grid) {
		if(grid == null||grid.length ==0) {
			return 0;
		} 
		UnionFind1 uf = new UnionFind1(grid);
			int row = grid.length;
			int column = grid[0].length;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (grid[i][j] == '1') {
						// check right and down
						if((j+1<column) &&grid[i][j+1]=='1') {
							uf.union(i * column + j, i*column+j+1);
						}
						if((i+1<row)&&grid[i+1][j]=='1'){
							uf.union(i * column + j, (i+1)*column+j);
						}
					}
				}
			}
			return uf.count();
	 }
}

class UnionFind1 {
	private int[] id; // parent links
	private int[] sz; // size of components for roots
	private int count; // number of components

	public UnionFind1(char[][] grid) {
		count =0;
		int row = grid.length;
		int column = grid[0].length;
		int capacity = row * column;
		id = new int[capacity];
		sz = new int[capacity];

		System.out.println(row +", "+column );
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < column; ++j) {
				System.out.println(i +", "+j);
				id[i * column + j] = i * column + j;
				sz[i * column + j] = 1;
				if (grid[i][j] == '1') {
					count++;
				}
			}
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		// follow links to find a root.
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		// make smaller root point to larger one
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

}
