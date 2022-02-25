import React from "react";
import { StatusBar, View , StyleSheet ,Text } from "react-native";

const SigninHeader = () =>{
    return (
        <View>
            <StatusBar  
                animated={true}
                backgroundColor="dodgerblue"
                hidden={false} 
            />
            <View style = {styles.container}>
                <Text style={styles.logo}>Logo</Text>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container : {
        height: 200,
        backgroundColor : 'dodgerblue'
    },
    logo : {
        color : 'white',
        fontSize: 30,
        marginLeft: 'auto',
        marginRight: 'auto',
        marginTop: 50,
    }
});
export default SigninHeader;