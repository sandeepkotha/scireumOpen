/**
 * Copyright (c) 2012 scireum GmbH - Andreas Haufler - aha@scireum.de
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package examples;

import java.text.DateFormat;
import java.util.Date;

import com.scireum.open.nucleus.Nucleus;
import com.scireum.open.nucleus.timer.EveryMinute;

//@Register(classes = EveryMinute.class)
public class ExampleNucleus implements EveryMinute {

	public static void main(String[] args) throws Exception {
		Nucleus.init();
		// We could use the @Register annotation as indicated above - but then
		// it would be always triggered, no matter which of the examples you
		// start, since it is always discovered as a class.
		Nucleus.register(EveryMinute.class, new ExampleNucleus());
		while (true) {
			Thread.sleep(1000);
		}
	}

	@Override
	public void runTimer() throws Exception {
		System.out.println("The time is: "
				+ DateFormat.getTimeInstance().format(new Date()));
	}

}