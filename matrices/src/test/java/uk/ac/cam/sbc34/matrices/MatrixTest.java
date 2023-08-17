/*
 * Copyright 2023 Andrew Rice <acr31@cam.ac.uk>, S.B. Cashell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.sbc34.matrices;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MatrixTest {

  @Test
  public void add_producesCorrectAnswer() {
    // ARRANGE
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3}, //
              {4, 5, 6}
            });
    Matrix b =
        new Matrix(
            new double[][] {
              {7, 8, 9}, //
              {10, 11, 12},
            });

    // ACT
    Matrix c = a.add(b);

    // ASSERT
    assertThat(c.get(0, 0)).isWithin(1E-7).of(8);
    assertThat(c.get(0, 1)).isWithin(1E-7).of(10);
    assertThat(c.get(0, 2)).isWithin(1E-7).of(12);
    assertThat(c.get(1, 0)).isWithin(1E-7).of(14);
    assertThat(c.get(1, 1)).isWithin(1E-7).of(16);
    assertThat(c.get(1, 2)).isWithin(1E-7).of(18);
  }
@Test
  public void Immutable()
{
  //ARRANGE
  double[][] D = new double[][] {
          {1, 2, 3},
          {4, 5, 6} };

  double[][] D_Copy = new double[D.length][D[0].length];

  for(int i = 0; i<D.length; i++)
  {
    for(int j = 0; j<D[0].length; j++)
    {
      D_Copy[i][j] = D[i][j];
    }
  }

  Matrix A = new Matrix( D );

  //ACT
  D[0][0] = 0;

  //ASSERT
  for(int i = 0; i<D.length; i++)
  {
    for(int j = 0; j<D[0].length; j++)
    {
      assertThat(A.get(i, j)).isEqualTo(D_Copy[i][j]);
    }
  }
}

@Test
  public void mult_producesCorrectAnswer()
{
  //ARRANGE
  Matrix a =
          new Matrix(
                  new double[][] {
                          {1, 2, 3}, //
                          {4, 5, 6}
                  });
  Matrix b =
          new Matrix(
                  new double[][] {
                          {7, 8},
                          {9, 10}, //
                          {11, 12}
                  });

  //ACT
  Matrix c = a.mult(b);

  //ASSERT
  assertThat(c.get(0, 0)).isWithin(1E-7).of(58);
  assertThat(c.get(0, 1)).isWithin(1E-7).of(64);
  assertThat(c.get(1, 0)).isWithin(1E-7).of(139);
  assertThat(c.get(1, 1)).isWithin(1E-7).of(154);
}
@Test
  public void transpose_producesCorrectAnswer()
{
  //ARRANGE
  Matrix a =
          new Matrix(
                  new double[][] {
                          {1, 2, 3}, //
                          {4, 5, 6}
                  });
  //ACT
  Matrix b = a.transpose();
  //ASSERT
  assertThat(b.get(0, 0)).isEqualTo(1);
  assertThat(b.get(0, 1)).isEqualTo(4);
  assertThat(b.get(1, 0)).isEqualTo(2);
  assertThat(b.get(1, 1)).isEqualTo(5);
  assertThat(b.get(2, 0)).isEqualTo(3);
  assertThat(b.get(2, 1)).isEqualTo(6);

}








}


