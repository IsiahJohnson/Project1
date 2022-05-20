import React, { ReactNode, useEffect } from 'react';

import { useSelector, useDispatch } from 'react-redux';
import { Navbar } from '../../Components/Navbar/Navbar';
import { RootState, AppDispatch } from '../../Store';
import { useNavigate } from 'react-router-dom';

import ReimbursementSlice, { getReimbursements } from '../../Slices/ReimbursementSlice';

import { CreateReimbursement } from '../../Components/CreateReimbursement/CreateReimbursement';
import { Loading } from '../../Components/Loading/Loading';
import { IReimbursement } from '../../Interfaces/IReimbursement';

//import './ReimbursementPage.css';
import { Reimbursement } from '../../Components/Reimbursement/Reimbursement';

export const ReimbursementPage: React.FC = () => {

    const userInfo = useSelector((state:RootState) => state.user);
    const reimbursements = useSelector((state:RootState) => state.reimbursements);
    const navigator = useNavigate();
    const dispatch:AppDispatch = useDispatch();

    useEffect(() => {
        //If the user is not logged in, push them to the login page
        if(!userInfo.user){
            navigator("/login");
        }
        //If the user IS logged in, but we have not gotten their reimbursements yet
        else if(userInfo.user && !reimbursements.reimbursements){
            dispatch(getReimbursements(userInfo.user.userId));
        }

        console.log("Userstate: ", userInfo, "Reimbursements: ", reimbursements);
    }, [userInfo, reimbursements.reimbursements]);

    return(
        <div>
            <Navbar />
            <div className="reimbursement-page">
                <CreateReimbursement />
                {reimbursements.reimbursements ? reimbursements.reimbursements.map((reimbursement:IReimbursement) => {
                    return <Reimbursement {...reimbursement} key={reimbursement.reimbursementId} />
                }) :
                <Loading />
                }
            </div>
        </div>
    )

    /*
    {posts.posts ? posts.posts.map((post:IPost) => {
                    return <Post {...post} key={post.postId} />
                }) :
                <Loading />
                }
    */

}