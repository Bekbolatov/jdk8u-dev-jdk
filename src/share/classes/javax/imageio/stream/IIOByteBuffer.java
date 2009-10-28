/*
 * Copyright 1999-2001 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package javax.imageio.stream;

/**
 * A class representing a mutable reference to an array of bytes and
 * an offset and length within that array.  <code>IIOByteBuffer</code>
 * is used by <code>ImageInputStream</code> to supply a sequence of bytes
 * to the caller, possibly with fewer copies than using the conventional
 * <code>read</code> methods that take a user-supplied byte array.
 *
 * <p> The byte array referenced by an <code>IIOByteBuffer</code> will
 * generally be part of an internal data structure belonging to an
 * <code>ImageReader</code> implementation; its contents should be
 * considered read-only and must not be modified.
 *
 */
public class IIOByteBuffer {

    private byte[] data;

    private int offset;

    private int length;

    /**
     * Constructs an <code>IIOByteBuffer</code> that references a
     * given byte array, offset, and length.
     *
     * @param data a byte array.
     * @param offset an int offset within the array.
     * @param length an int specifying the length of the data of
     * interest within byte array, in bytes.
     */
    public IIOByteBuffer(byte[] data, int offset, int length) {
        this.data = data;
        this.offset = offset;
        this.length = length;
    }

    /**
     * Returns a reference to the byte array.  The returned value should
     * be treated as read-only, and only the portion specified by the
     * values of <code>getOffset</code> and <code>getLength</code> should
     * be used.
     *
     * @return a byte array reference.
     *
     * @see #getOffset
     * @see #getLength
     * @see #setData
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Updates the array reference that will be returned by subsequent calls
     * to the <code>getData</code> method.
     *
     * @param data a byte array reference containing the new data value.
     *
     * @see #getData
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * Returns the offset within the byte array returned by
     * <code>getData</code> at which the data of interest start.
     *
     * @return an int offset.
     *
     * @see #getData
     * @see #getLength
     * @see #setOffset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Updates the value that will be returned by subsequent calls
     * to the <code>getOffset</code> method.
     *
     * @param offset an int containing the new offset value.
     *
     * @see #getOffset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Returns the length of the data of interest within the byte
     * array returned by <code>getData</code>.
     *
     * @return an int length.
     *
     * @see #getData
     * @see #getOffset
     * @see #setLength
     */
    public int getLength() {
        return length;
    }

    /**
     * Updates the value that will be returned by subsequent calls
     * to the <code>getLength</code> method.
     *
     * @param length an int containing the new length value.
     *
     * @see #getLength
     */
    public void setLength(int length) {
        this.length = length;
    }
}
