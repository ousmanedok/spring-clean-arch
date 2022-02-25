import React from "react";
import {Picker} from '@react-native-picker/picker';
import {StyleSheet, View , Text} from "react-native";

const Countries = (props) =>{

        const countries = ["Guinée" , "Mauritanie"];

    return(
        <View style={styles.container}>
                <Picker
                    selectedValue={props.selectedValue}
                    style={styles.piker}
                    onValueChange={props.onValueChange}
                >
                    <Picker.Item label="Pays" value="" />
                    
                {
                    countries?.map((pays , index)=>(
                        <Picker.Item key={index} label={countries[index]} value={countries[index]} />
                    ))
                }
                </Picker>
                { props.errorDetails && (
                    <Text style={styles.error}>{props.errorDetails}</Text>
                )}
        </View>
    );
}

const styles = StyleSheet.create({
    error:{
        marginTop:4,
        fontSize:10,
        color:'red'
    },
    piker: {
        flex: 1,
        borderColor:'gray',
        
      }
});

export default Countries;