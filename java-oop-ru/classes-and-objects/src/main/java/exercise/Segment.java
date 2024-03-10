package exercise;

// BEGIN
class Segment {
    private Point beginPoint;
    private Point endPoint;

    Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int x = ((endPoint.getX() - beginPoint.getX()) / 2) + beginPoint.getX();
        int y = ((endPoint.getY() - beginPoint.getY()) / 2) + beginPoint.getY();
        return new Point(x, y);
    }
}
// END
