package com.clouidio.orm.layer3.typed;

import java.util.Iterator;

import com.clouidio.orm.api.z8spi.conv.Precondition;
import com.clouidio.orm.api.z8spi.iter.Cursor;

public class IterableProxy<T> implements
		Iterable<T> {

	private Cursor<T> cursor;

	public IterableProxy(Cursor<T> cursor) {
		Precondition.check(cursor, "cursor");
		this.cursor = cursor;
	}

	@Override
	public Iterator<T> iterator() {
		//restart cursor
		cursor.beforeFirst();
		return new IteratorProxy<T>(cursor);
	}
	
	private static class IteratorProxy<T> implements Iterator<T> {

		private Cursor<T> cursor;
		private T cachedValue;
		
		public IteratorProxy(Cursor<T> cursor) {
			this.cursor = cursor;
		}

		@Override
		public boolean hasNext() {
			if(cachedValue != null)
				return true;
			boolean hasNext = cursor.next();
			if(hasNext) 
				cachedValue = cursor.getCurrent();
			return hasNext;
		}

		@Override
		public T next() {
			if(!hasNext())
				throw new IllegalStateException("You should call hasNext first!!! This iterator has no more values");
			
			T temp = cachedValue;
			cachedValue = null;
			return temp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("not supported");
		}
	}
}
