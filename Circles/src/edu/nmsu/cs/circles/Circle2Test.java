package edu.nmsu.cs.circles;
import org.junit.*;
public class Circle2Test {
	// Data you need for each test case
		private Circle1 circle2;

		//
		// Stuff you want to do before each test case
		//
		@Before
		public void setup()
		{
			System.out.println("\nTest starting...");
			circle2 = new Circle1(1, 2, 3);
		}

		//
		// Stuff you want to do after each test case
		//
		@After
		public void teardown()
		{
			System.out.println("\nTest finished.");
		}

		//
		// Test a simple positive move
		//
		@Test
		public void simpleMove()
		{
			Point p;
			System.out.println("Running test simpleMove.");
			p = circle2.moveBy(1, 1);
			Assert.assertTrue(p.x == 2 && p.y == 3);
		}

		//
		// Test a simple negative move
		//
		@Test
		public void simpleMoveNeg()
		{
			Point p;
			System.out.println("Running test simpleMoveNeg.");
			p = circle2.moveBy(-1, -1);
			Assert.assertTrue(p.x == 0 && p.y == 1);
		}

		/***
		 * NOT USED public static void main(String args[]) { try { org.junit.runner.JUnitCore.runClasses(
		 * java.lang.Class.forName("Circle1Test")); } catch (Exception e) { System.out.println("Exception:
		 * " + e); } }
		 ***/
		<project name="testCircle2" default="dist" basedir=".">
		  <description>
		    simple example build file
		  </description>
		  <!-- set global properties for this build -->
		  <property name="src" location="src"/>
		  <property name="build" location="build"/>
		  <property name="dist" location="dist"/>

		  <target name="init">
		    <!-- Create the time stamp -->
		    <tstamp/>
		    <!-- Create the build directory structure used by compile -->
		    <mkdir dir="${build}"/>
		  </target>

		  <target name="compile" depends="init"
		        description="compile the source">
		    <!-- Compile the Java code from ${src} into ${build} -->
		    <javac srcdir="${src}" destdir="${build}"/>
		  </target>

		  <target name="dist" depends="compile"
		        description="generate the distribution">
		    <!-- Create the distribution directory -->
		    <mkdir dir="${dist}/lib"/>

		    <!-- Put everything in ${build} into the MyProject-${DSTAMP}.jar file -->
		    <jar jarfile="${dist}/lib/MyProject-${DSTAMP}.jar" basedir="${build}"/>
		  </target>

		  <target name="clean"
		        description="clean up">
		    <!-- Delete the ${build} and ${dist} directory trees -->
		    <delete dir="${build}"/>
		    <delete dir="${dist}"/>
		  </target>
		</project>
}
