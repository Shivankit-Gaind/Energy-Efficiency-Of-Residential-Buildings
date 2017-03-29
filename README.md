# Energy-Efficiency-Of-Residential-Buildings
The project is an android application presented in technical festival of BITS Pilani - APOGEE 2017, to predict the dependence of energy efficiency of a residential building of a particular area on its structure and design (taking 8 structural parameters as input). The energy efficiency is calculated in terms of the Heating Load and Cooling Load of the building which can further help to modify the building design for achieving maximum possible energy conservation in future. The application involves the use of machine learning algorithms trained as per the previous available data for that area.

Input Parameters For Predicting HL and CL:
1. Relative Compactness  
2. Surface Area 
3. Wall Area  
4. Roof Area  
5. Overall Height  
6. Orientation 
7. Glazing Area  
8. Glazing Area Distribution 

The procedure to arrive at the Decision Tree Regressor Model is explained in the ipython notebook. The same model is trained for the data we have and further used to predict the HL and CL values using the inputs from the user through the app, the computation being done on a django server.
