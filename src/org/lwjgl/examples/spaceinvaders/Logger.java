package org.lwjgl.examples.spaceinvaders;

import java.util.Formatter;
import java.util.Locale;


public class Logger
{
  public static void print(String string)
  { printStack(4, "%s", string); }
  
  public static void print(String format, Object... args)
  { printStack(4, format, args); }
  
  public static void printStack
  (final int frame, final String format, final Object... args)
  {
    StringBuilder b  = new StringBuilder();
    @SuppressWarnings("resource")
    Formatter f = new Formatter(b, Locale.US);
    if((format != null) && (format.length() > 0))
    {  f.format(format, args); }
    else
    { b.append(" "); }
    
    StackTraceElement e = Thread.currentThread().getStackTrace()[frame];
    System.out.print
    (String.format("[%s:%d] %s", e.getFileName(), e.getLineNumber(), b.toString()));
  }
}
