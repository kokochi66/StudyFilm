// int rectangleRotation(int a, int b) {
//     double x0 = -(double)b/2;
//     double y0 = (double)a/2;
    
//     double tx0 = sqrt(2)/2*(x0+y0);
//     double ty0 = sqrt(2)/2*(-x0+y0);
    
//     int cnt = 0;
//     for(int y=-ceil(ty0);y<=ceil(ty0);y++){
//         for(int x=-ceil(ty0);x<=ceil(ty0);x++){
//             if((y-x)>sqrt(2)*x0&&(y-x)<-sqrt(2)*x0){
//                 if((y+x)<sqrt(2)*y0&&(y+x)>-sqrt(2)*y0) cnt++;
//             }
//         }
//     }
//     return cnt;
// }
// //내가푼거아님 반성.