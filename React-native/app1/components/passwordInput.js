import React from "react";
import {StyleSheet , TextInput, View , Text} from "react-native";

const PasswordInput = (props) =>{
    return (
        <View>
            <TextInput
                        style={styles.input}
                        placeholder={props.placeholder}
                        secureTextEntry={true}
                        value={props.value}
                        onChangeText={props.onChangeText}
            />
            { props.errorDetails && (
                    <Text style={styles.error}>{props.errorDetails}</Text>
                )
            }
        </View>
    );
}
const styles = StyleSheet.create({
    input:{
        padding:10,
        height:60,
        borderBottomWidth: StyleSheet.hairlineWidth
    },
    error:{
        marginTop:4,
        fontSize:10,
        color:'red'
    }
});
export default PasswordInput;