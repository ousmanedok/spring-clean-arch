import React from 'react';
import ArticleList from './components/articleList';
import ApiError from './components/apiError';
import {useSelector } from "react-redux";
import SignUp from './components/signUp';
import SignIn from './components/SignIn';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const Stack = createNativeStackNavigator();

const App = () => {
  const message = useSelector(state => state?.apiError?.message);
  return (
          <NavigationContainer>
              <Stack.Navigator>
                  <Stack.Screen name="SignUp" component={SignUp} options={{headerShown: false}} />
                  <Stack.Screen name="Home" component={ArticleList} 
                    options={{ 
                        headerStyle:{
                          backgroundColor: 'dodgerblue'
                        },
                        headerTintColor: '#fff'
                    }}  
                  />
                  <Stack.Screen name="SignIn" component={SignIn} options={{headerShown: false}} />
              </Stack.Navigator>
          </NavigationContainer>
    );
}
export default App;