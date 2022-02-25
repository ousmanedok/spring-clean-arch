import React from "react";
import { Card, Title  } from "react-native-paper";
import {StyleSheet, View , Button , Text , ScrollView} from 'react-native';
import InputText from "./inputText";
import PasswordInput from "./passwordInput";
import SigninHeader from "./signinHeader";

const SignIn = ({navigation}) =>{
    return (
            <ScrollView>
                <SigninHeader/>
                <Card style = {styles.card}>
                    <Card.Content>
                            <Title style = {styles.title}>Sign In</Title>
                            <InputText placeholder ="Email"  key = {3}/>
                            <PasswordInput placeholder="Mot de passe" key={4}/>      
                    </Card.Content>
                    <View style={{ marginTop:50 }} >
                        <Text style={styles.signup}>
                                Mot de passe oublié ?
                        </Text>
                </View>
                   <View style={styles.button}>
                        <Button              
                                title="Se connecter"
                                color="dodgerblue"
                        />
                   </View>
                </Card>
                <View style={{ marginTop:40 }} >
                        <Text
                                style={styles.signup}
                                onPress={() => navigation.navigate('SignUp')}>
                                Vous n'avez pas de compte ? Inscrivez-vous
                        </Text>
                </View>
            </ScrollView>     
    );
}
const styles = StyleSheet.create({
    card: {
        marginTop: -50,
        marginHorizontal:30,
        elevation : 15,
    },
    title:{
        textAlign: 'center',
        textTransform : 'uppercase',
        color: 'dodgerblue',
        marginBottom : 10
    },
    button:{
        marginVertical: 30,
        paddingHorizontal:25
    },
    signup:{
        color: 'dodgerblue',
        textAlign: 'center'
    }
});
export default SignIn;
