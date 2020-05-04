package com.graph;

public class UnionFind {
	private int[] id; // parent links
	private int[] sz; // size of components for roots
	private int count; // number of components

	public UnionFind(int N) {
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
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
