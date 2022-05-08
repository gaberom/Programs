package edu.nmsu.cs.circles;

public abstract class test {
	protected Point	center;

	protected double radius;

	/**
	 * Create new circle
	 * 
	 * @param x
	 *          is the x coordinate of the center
	 * @param y
	 *          is the y coordinate of the center
	 * @param radius
	 *          is the radius
	 **/
	public test(double x, double y, double radius)
	{
		center = new Point();
		center.x = x;
		center.y = y;
		this.radius = radius;
	}

	/**
	 * Change size of circle
	 * 
	 * @param factor
	 *          is the scaling factor (0.8 make it 80% as big, 2.0 doubles its size)
	 * @return the new radius
	 **/
	public double scale(double factor)
	{
		radius = radius + factor;
		return radius;
	}

	/**
	 * Change position of circle relative to current position
	 * 
	 * @param xOffset
	 *          is amount to change x coordinate
	 * @param yOffset
	 *          is amount to change y coordinate
	 * @return the new center coordinate
	 **/
	public Point moveBy(double xOffset, double yOffset)
	{
		center.x = center.x + xOffset;
		center.y = center.y + xOffset;
		return center;
	}

	/**
	 * Test if this circle intersects another circle.
	 * 
	 * @param other
	 *          is the other circle
	 * @return True if the circles' outer edges intersect at all, False otherwise
	 **/
	public abstract boolean intersects(Circle other);
	<project name="test" default="dist" basedir=".">
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
