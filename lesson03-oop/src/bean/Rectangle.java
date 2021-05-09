package bean;

public class Rectangle {
	// attributes
		private int width;
		private int height;

		// default: empty constructor
		public Rectangle() {

		}

		// constructor with 2 parameters
		public Rectangle(int paraWidth, int paraHeight) {
			this.width = paraWidth;
			this.height = paraHeight;

		}

		// setter
		public void setWidth(int width) {
			this.width = width; 
		}

		// setter
		public int getWidth() {
			return this.width;
		}

		// "get" + ctrlSpace
		public int getHeight() {
			return height;
		}

		// ctrlSpace
		public void setHeight(int height) {
			this.height = height;
		}

		// "To" + ctrl + space
		@Override
		public String toString() {
			return "w" + this.width + "h" + this.height;
		}

}
