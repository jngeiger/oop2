package stopwatch;

public class Time {
private double t;

public Time()
{
	t = 0.0;
}

public void startTimer()
{
	t = System.currentTimeMillis();
}

public double getElapsedTime()
{
	if (t == 0.0)
	{
		return 0.0;
	}
	return System.currentTimeMillis() - t;
}

public void close()
{
	t = 0;
}

}
