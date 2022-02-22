import * as React from 'react';
import { StyleSheet , Text, View } from 'react-native';
import { Appbar } from 'react-native-paper';

const Header = () =>{
   

  return (
    <View>
        <Appbar.Header style={styles.appbar}> 
            <Appbar.Content title={<Text style={styles.title}>News</Text>}/>
        </Appbar.Header>
    </View>
  );
}

const styles = StyleSheet.create({

    appbar:{
      backgroundColor : 'blue' ,
      elevation: 5,
    },


    title :{
        color : 'white',
    }

  
  });
  

export default Header;