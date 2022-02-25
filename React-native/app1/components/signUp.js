import React from "react";
import { Card, Title  } from "react-native-paper";
import {StyleSheet, View , Button , Text , ScrollView} from 'react-native';
import InputText from "./inputText";
import PasswordInput from "./passwordInput";
import SigninHeader from "./signinHeader";
import * as Yup from "yup";
import { Controller, useForm } from "react-hook-form";
import {yupResolver} from "@hookform/resolvers/yup";
import { addUser } from "../actions/user";
import { useDispatch } from "react-redux";
import Countries from "./countries";
const SignUp = ({navigation}) =>{

    const validationSchema = Yup.object({
        nom:                    Yup.string().required("Veuillez saisir votre nom"),
        prenom:                 Yup.string().required("Veuillez saisir votre prénom"),
        email:                  Yup.string()
                                   .email("Veuillez saisir une adresse mail valide") 
                                   .required("Veuillez saisir une adresse mail"),
        motDePasse:             Yup.string()
                                   .min(6, "Veuillez saisir au moins 6 caractères")
                                   .required("Veuillez saisir le mot de passe"), 
        confirmer_motDePasse:   Yup.string()
                                   .required("Veuillez confirmer le mot de passe")
                                   .oneOf([Yup.ref("motDePasse")] , "Les mots de passe ne correspondent pas"),
        pays:                  Yup.string().required("Veuillez selectionner votre pays"),
        ville:                  Yup.string().required("Veuillez saisir votre ville")                    
    }).required();

    const {
        control , 
        handleSubmit , 
        clearErrors,
    } = useForm({
        resolver: yupResolver(validationSchema),
    });

    const dispatch = useDispatch();
    const signup = (user) =>{
        clearErrors();
        dispatch(addUser(user));
        navigation.navigate('Home', {user});
    }

    return (
            <ScrollView>
                <SigninHeader/>
                <Card style = {styles.card}>
                    <Card.Content>
                            <Title style = {styles.placeholder}>Sign Up</Title>
                            <Controller control={control} name="nom" render={({field: {onChange , value} , fieldState: {error}}) => (
                                <InputText 
                                    placeholder ="Nom" 
                                    value={value} 
                                    onChangeText={onChange} 
                                    key = {1}
                                    error={error}
                                    errorDetails={error?.message}
                                    
                                />
                            )}/>
                            <Controller control={control} name="prenom" render={({field: {onChange , value} , fieldState: {error}}) => (
                                <InputText 
                                    placeholder ="Prenom" 
                                    value={value} 
                                    onChangeText={onChange}  
                                    key = {2}
                                    error={error}
                                    errorDetails={error?.message}
                                    />
                                    
                            )}/>
                            <Controller control={control} name="email" render={({field: {onChange , value} , fieldState: {error}}) => (
                                    <InputText 
                                        placeholder ="Email" 
                                        value={value} 
                                        onChangeText={onChange} 
                                        key = {3}
                                        error={error}
                                        errorDetails={error?.message}
                                    />
                            )}/>
                            <Controller control={control} name="motDePasse" render={({field: {onChange , value} , fieldState: {error}}) => (
                                <PasswordInput
                                placeholder="Mot de passe" 
                                    value={value} 
                                    onChangeText={onChange} 
                                    key={4}
                                    error={error}
                                    errorDetails={error?.message}
                                />
                            )}/>
                            <Controller control={control} name="confirmer_motDePasse" render={({field: {onChange , value} , fieldState: {error}}) => (
                                <PasswordInput
                                placeholder="Confirmer le mot de passe" 
                                    value={value} 
                                    onChangeText={onChange} 
                                    key={5}
                                    error={error}
                                    errorDetails={error?.message}
                                 />
                            )}/>
                            <Controller control={control} name="pays" render={({field: {onChange , value} , fieldState: {error}}) => (
                                <Countries
                                    selectedValue={value}
                                    onValueChange={onChange}
                                    error={error}
                                    errorDetails={error?.message}
                                />
                            )}/>
    
                            <Controller control={control} name="ville" render={({field: {onChange , value} , fieldState: {error}}) => (
                                <InputText 
                                    style={{ marginBottom : 20 }} 
                                    placeholder ="Ville" 
                                    value={value} 
                                    onChangeText={onChange} 
                                    key = {6}
                                    error={error}
                                    errorDetails={error?.message}
                                /> 
                            )}/>
                  </Card.Content>
                   <View style={styles.button}>
                        <Button              
                                title="Creer un compte"
                                color="dodgerblue"
                                onPress={handleSubmit(signup)}
                        />
                   </View>
                </Card>
                <View style={{ marginTop:40 }} >
                        <Text
                                style={styles.signin}
                                onPress={() => navigation.navigate('SignIn')}>
                                Vous avez un compte ? Connectez-vous
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
    placeholder:{
        textAlign: 'center',
        textTransform : 'uppercase',
        color: 'dodgerblue',
        marginBottom : 10
    },
    button:{
        marginVertical: 30,
        paddingHorizontal:25
    },
    signin:{
        color: 'dodgerblue',
        textAlign: 'center'
    }
});
export default SignUp;
