/**
 * This program analyzes a series of coordinates on a Cartesian plane.
 * It calculates the closest and furthest points from the origin (0, 0),
 * the average distance of all points to the origin, and checks if there
 * are any points on the axes (x = 0 or y = 0). Points in the third
 * quadrant (x < 0, y < 0) are ignored.
 * 
 * Author: Lucas Murillo
 */
package com.coordinateanalysis.main;

import java.util.Scanner;// Import for reading inputs from the console

/**
 * Main class for the Coordinate Analysis program.
 */
public class CoordinateAnalysis {

	/**
	 * The main method is the entry point of the program.
	 * It reads user input for coordinates and processes them
	 * to calculate the desired results.
	 * 
	 * @param args Command-line arguments (not used in this program)
	 */
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize the Scanner for input
        int x, y; // Variables to hold the x and y coordinates
        boolean pointsOnAxes = false; // Flag to check if there are points on the axes
        double minDistance = Double.MAX_VALUE; // Initialize minimum distance to a large value
        double maxDistance = Double.MIN_VALUE; // Initialize maximum distance to a small value
        double totalDistance = 0; // Sum of all distances
        int count = 0; // Counter for valid points
        int closestX = 0, closestY = 0; // Variables to store the closest point
        int furthestX = 0, furthestY = 0; // Variables to store the furthest point

        // Loop to read coordinates until (0, 0) is entered
        while (true) {
            System.out.print("Enter x coordinate: ");
            x = scanner.nextInt(); // Read x coordinate
            System.out.print("Enter y coordinate: ");
            y = scanner.nextInt(); // Read y coordinate

            // Check for the end condition
            if (x == 0 && y == 0) break;

            // Ignore points in the third quadrant
            if (x < 0 && y < 0) continue;

            // Check if point is on any axis
            if (x == 0 || y == 0) pointsOnAxes = true;

            // Calculate distance from the origin (0, 0)
            double distance = Math.sqrt(x * x + y * y);

            // Update closest and furthest points
            if (distance < minDistance) {
                minDistance = distance;
                closestX = x;
                closestY = y;
            }
            if (distance > maxDistance) {
                maxDistance = distance;
                furthestX = x;
                furthestY = y;
            }

            // Accumulate total distance and increment counter
            totalDistance += distance;
            count++;
        }

        // Calculate average distance
        double averageDistance = (count > 0) ? totalDistance / count : 0;

        // Print the results
        System.out.println("Closest to origin: " + closestX + " " + closestY);
        System.out.println("Furthest from origin: " + furthestX + " " + furthestY);
        System.out.println("Average distance to origin: " + averageDistance);
        System.out.println("Points on axes: " + (pointsOnAxes ? "Yes" : "No"));
    }
}