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

/** A static class for constructing matrices with 2d shapes. */
class Shapes {

  /**
   * Create a new 2x2 matrix which applies a rotation
   *
   * @param degrees to rotate by
   * @return a 2x2 matrix
   */
  static Matrix rotation2d(double degrees) {
    double[][] rotation = new double[2][2];
    double radians = Math.PI*degrees/180;
    rotation[0][0] = Math.cos(radians);
    rotation[0][1] = Math.sin(-radians);
    rotation[1][0] = Math.sin(radians);
    rotation[1][1] = Math.cos(radians);
    return(new Matrix(rotation));
  }

  /** Create a new identity matrix with the specified size. */
  static Matrix identity(int size) {
    double[][] data = new double[size][size];
    for (int i = 0; i < size; i++) {
      data[i][i] = 1;
    }
    return new Matrix(data);
  }

  /**
   * Create a new matrix representing the points on the perimeter of a square centred on (0,0).
   *
   * @param size the length of half an edge i.e. the square will run from -size to size
   * @return a matrix of height 2 with each column representing a point on the square
   */
  static Matrix square(int size) {
    double[][] square = new double[2][8*size+4];
    for(int i = -size; i<=size; i++)
    {
      square[0][i+size] = size;
      square[1][i+size] = i;

      square[0][i+2*size+2] = i;
      square[1][i+2*size+2] = size;

      square[0][i+4*size+3] = -size;
      square[1][i+4*size+3] = i;

      square[0][i+6*size+4] = i;
      square[1][i+6*size+4] = -size;
    }
    return new Matrix(square);

  }

  // No instances
  private Shapes() {}
}
