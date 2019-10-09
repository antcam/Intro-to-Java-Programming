/*
(Geography: estimate areas) Find the GPS locations for Atlanta, Georgia;
Orlando, Florida; Savannah, Georgia; and Charlotte, North Carolina from
www.gps-data-team.com/map/ and compute the estimated area enclosed by these
four cities. (Hint: Use the formula in Programming Exercise 4.2 to compute the
distance between two cities. Divide the polygon into two triangles and use the
formula in Programming Exercise 2.19 to compute the area of a triangle.)
*/
public class Exercises_04_03 {
    public static void main(String[] args){
        System.out.println("Atlanta, Georgia 33.7489954, -84.3879824");
        System.out.println("Orlando, Florida 28.538335,-81.379236");
        System.out.println("Savannah, Georgia  32.080899, -81.091203");
        System.out.println("Charlotte, North Carolina 35.227087, -80.843127");

        final double RADIUS = 6371.01;	// Constant value

        double xAtlantaGeorgia = 33.7489954;
        double yAtlantaGeorgia = -84.3879824;
        double xOrlandoFlorida = 28.538335;
        double yOrlandoFlorida = -81.379236;
        double xSavannahGeorgia = 32.080899;
        double ySavannahGeorgia = -81.091203;
        double xCharlotteNorthCarolina = 35.227087;
        double yCharlotteNorthCarolina = -80.843127;

        // Convert degrees to radians
        xAtlantaGeorgia = Math.toRadians(xAtlantaGeorgia);
        yAtlantaGeorgia = Math.toRadians(yAtlantaGeorgia);
        xOrlandoFlorida = Math.toRadians(xOrlandoFlorida);
        yOrlandoFlorida = Math.toRadians(yOrlandoFlorida);
        xSavannahGeorgia = Math.toRadians(xSavannahGeorgia);
        ySavannahGeorgia = Math.toRadians(ySavannahGeorgia);
        xCharlotteNorthCarolina = Math.toRadians(xCharlotteNorthCarolina);
        yCharlotteNorthCarolina = Math.toRadians(yCharlotteNorthCarolina);

        // Calculate its great circle distance Atlanta Georgia to Orlando Florida
        double distanceAtlantaGeorgiaToOrlandoFlorida =
                RADIUS * Math.acos(Math.sin(xAtlantaGeorgia) * Math.sin(xOrlandoFlorida) +
                        Math.cos(xAtlantaGeorgia) * Math.cos(xOrlandoFlorida) * Math.cos(yAtlantaGeorgia - yOrlandoFlorida));
        // Calculate its great circle distance Orlando Florida to Savannah Georgia
        double distanceOrlandoFloridaToSavannahGeorgia =
                RADIUS * Math.acos(Math.sin(xOrlandoFlorida) * Math.sin(xSavannahGeorgia) +
                        Math.cos(xOrlandoFlorida) * Math.cos(xSavannahGeorgia) * Math.cos(yOrlandoFlorida - ySavannahGeorgia));

        // Calculate its great circle distance Savannah Georgia to Charlotte North Carolina
        double distanceSavannahGeorgiaToCharlotteNorthCarolina =
                RADIUS * Math.acos(Math.sin(xSavannahGeorgia) * Math.sin(xCharlotteNorthCarolina) +
                        Math.cos(xSavannahGeorgia) * Math.cos(xCharlotteNorthCarolina) * Math.cos(ySavannahGeorgia - yCharlotteNorthCarolina));

        // Calculate its great circle distance Charlotte North Carolina to Atlanta Georgia
        double distanceCharlotteNorthCarolinaToAtlantaGeorgia =
                RADIUS * Math.acos(Math.sin(xCharlotteNorthCarolina) * Math.sin(xAtlantaGeorgia) +
                        Math.cos(xCharlotteNorthCarolina) * Math.cos(xAtlantaGeorgia) * Math.cos(yCharlotteNorthCarolina - yAtlantaGeorgia));

        // Calculate its great circle  Atlanta Georgia to SavannahGeorgia
        double distanceAtlantaGeorgiaToSavannahGeorgia =
                RADIUS * Math.acos(Math.sin(xAtlantaGeorgia) * Math.sin(xSavannahGeorgia) +
                        Math.cos(xAtlantaGeorgia) * Math.cos(xSavannahGeorgia) * Math.cos(yAtlantaGeorgia - ySavannahGeorgia));

        double side1 = (distanceAtlantaGeorgiaToOrlandoFlorida + distanceOrlandoFloridaToSavannahGeorgia + distanceAtlantaGeorgiaToSavannahGeorgia) / 2;

        double area1 = Math.sqrt (side1 * (side1 - distanceAtlantaGeorgiaToOrlandoFlorida) * (side1 - distanceOrlandoFloridaToSavannahGeorgia) * (side1 - distanceAtlantaGeorgiaToSavannahGeorgia));

        double side2 = (distanceSavannahGeorgiaToCharlotteNorthCarolina + distanceCharlotteNorthCarolinaToAtlantaGeorgia + distanceAtlantaGeorgiaToSavannahGeorgia) / 2;

        double area2 = Math.sqrt (side2 * (side2 - distanceSavannahGeorgiaToCharlotteNorthCarolina) * (side2 - distanceCharlotteNorthCarolinaToAtlantaGeorgia) * (side2 - distanceAtlantaGeorgiaToSavannahGeorgia));

        double totalArea = area1 + area2;

        System.out.printf("The area is %10.2f square kilometers",totalArea);




    }

}
