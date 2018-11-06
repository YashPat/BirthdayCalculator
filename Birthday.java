import javax.swing.JOptionPane;					
import java.util.Scanner;								
import java.util.Random;
import java.awt.*;								
import java.applet.*;								
import java.awt.event.*;								
import java.io.*;   //for files						
import java.net.*;
import javax.sound.midi.*;
import java.util.Vector;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import java.time.*;
import java.util.InputMismatchException;
import java.text.*;
import java.util.Date;
import java.time.temporal.*;
import java.time.format.*;

public class Birthday
{
	static Scanner scan = new Scanner(in);
	public static void main(String[] args)
	{
		do
		{
			LocalDate birthDate;
			DateTimeFormatter fullFormat = DateTimeFormatter.ofPattern("MMMM d, YYYY");
			DateTimeFormatter monthDayFormat = DateTimeFormatter.ofPattern("MMMM d");
			out.println("Today is " + LocalDate.now().format(fullFormat) + ".");
			out.println();
			out.print("Please enter your birthdate " + "(yyyy-mm-dd): ");
			String input = scan.nextLine();
			try
            {
				birthDate = LocalDate.parse(input);
				if (birthDate.isAfter(LocalDate.now()))
				{
					out.println("You haven't been born yet!");
					continue;
				}
				out.println();
				
				out.println(birthDate.format(fullFormat) + " was a very good date.");
				DayOfWeek birthDayOfWeek = birthDate.getDayOfWeek();
				out.println("You were born on a "
				  + birthDayOfWeek + ".");
				long years = birthDate.until(LocalDate.now(),ChronoUnit.YEARS);
				if (years > 100)
				{
					out.println("You are dead.");
				}
				out.println("You are " + years + " years old.");
				
				LocalDate nextBDay = birthDate.plusYears(years + 1);
				out.println("Your next birthday is " + nextBDay.format(fullFormat) + ".");
				long wait = LocalDate.now().until(nextBDay, ChronoUnit.DAYS);
				out.println("That's just " + wait + " days from now!");
				LocalDate halfBirthday = birthDate.plusMonths(6);
				out.println("Your half-birthday is " + halfBirthday.format(monthDayFormat) + ".");
			}
			catch (DateTimeParseException ex)
			{
				out.println("Sorry, that is not a valid date.");
			}
		} while(askAgain());
	}
	private static boolean askAgain()
	{
		out.println();
		out.println("Another? (Y or N) ");
		String reply = scan.nextLine();
		if (reply.equalsIgnoreCase("Y"))
		{
			return true;
		}
		return false;
	}
	
}
	
        		

