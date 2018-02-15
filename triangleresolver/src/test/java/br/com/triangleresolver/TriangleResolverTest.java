package br.com.triangleresolver;

import org.junit.Assert;
import org.junit.Test;

public class TriangleResolverTest {

	@Test
	public void oneRow() throws Exception {

		int[][] triangle = { { 10 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

		Assert.assertEquals(10, triangleResolver.maxTotal());

	}

	@Test
	public void twoRows() throws Exception {

		int[][] triangle = { { 10 }, { 3, 9 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

		Assert.assertEquals(19, triangleResolver.maxTotal());

	}

	@Test
	public void threeRows() throws Exception {

		int[][] triangle = { { 10 }, { 3, 9 }, { 4, 9, 2 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

		Assert.assertEquals(28, triangleResolver.maxTotal());

	}

	@Test
	public void fourRows() throws Exception {

		int[][] triangle = { { 10 }, { 3, 9 }, { 4, 9, 2 }, { 5, 3, 1, 7 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

		Assert.assertEquals(31, triangleResolver.maxTotal());

	}

	@Test
	public void fiveRows() throws Exception {

		int[][] triangle = { { 10 }, { 3, 9 }, { 4, 9, 2 }, { 5, 3, 1, 7 }, { 1, 5, 2, 9, 9 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

		Assert.assertEquals(36, triangleResolver.maxTotal());

	}

	@Test
	public void sixRows() throws Exception {

		int[][] triangle = { { 10 }, { 3, 9 }, { 4, 9, 2 }, { 5, 3, 1, 7 }, { 1, 5, 2, 9, 9 }, { 4, 5, 9, 1, 2, 4 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

		Assert.assertEquals(45, triangleResolver.maxTotal());

	}

	@Test(expected = Exception.class)
	public void wrongPatternOneLineTriangle() throws Exception {

		int[][] triangle = { { 8, 6, 10 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

	}

	@Test(expected = Exception.class)
	public void wrongPatternTwoLinesTriangle() throws Exception {

		int[][] triangle = { { 10, 7 }, { 3, 9 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

	}

	@Test(expected = Exception.class)
	public void wrongPatternThreeLinesTriangle() throws Exception {

		int[][] triangle = { { 10 }, { 9 }, { 8, 6, 10 } };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

	}

	@Test(expected = Exception.class)
	public void wrongPatternFourLineTriangle() throws Exception {

		int[][] triangle = { { 10 }, { 9, 7 }, { 8, 6, 10 }, {4, 6, 5} };

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

	}

}
