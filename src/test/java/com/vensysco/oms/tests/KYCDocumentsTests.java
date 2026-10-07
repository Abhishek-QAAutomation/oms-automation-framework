package com.vensysco.oms.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.KYCDocumentsPage;
import com.vensysco.oms.pages.LoginPage;
import com.vensysco.oms.pages.ProfileDashboardPage;

public class KYCDocumentsTests extends BaseTest {

    @Test
    public void verifyDocumentUpload() throws IOException {

        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(properties.getProperty("email"));
        loginPage.enterPassword(properties.getProperty("password"));
        loginPage.clickLoginBtn();
        
        //ProfileDashboard
        ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
        profileDashboardPage.clickKYCDocumentsBtn();

        //KYC Documents
        KYCDocumentsPage kycDocuments = new KYCDocumentsPage(driver);

        //File paths
        String proofOfEmployment ="/home/vtl/Downloads/teting documents/SampleLetterOfEmployment.pdf";
        String educationalDocument ="/home/vtl/Downloads/teting documents/SampleEducationCertificate.pdf";
        String lastOrganisationProof ="/home/vtl/Downloads/teting documents/SampleExperienceCertificate.pdf";
        String aadhaarCard ="/home/vtl/Downloads/teting documents/SampleAadhar.jpg";
        String panCard ="/home/vtl/Downloads/teting documents/SamplePan.jpg";
        String bankAccountProof ="/home/vtl/Downloads/teting documents/SampleBankStatement.jpg";

        //Upload documents
        kycDocuments.uploadDocuments("Proof of Employment",proofOfEmployment);
        kycDocuments.uploadDocuments("Educational Document",educationalDocument);
        kycDocuments.uploadDocuments("Last Organisation Proof",lastOrganisationProof);
        kycDocuments.uploadDocuments("Aadhaar Card",aadhaarCard);
        kycDocuments.uploadDocuments("PAN Card",panCard);
        kycDocuments.uploadDocuments("Bank Account Proof",bankAccountProof);

        //Verify uploads

        Assert.assertTrue(kycDocuments.isFileUploaded("Proof of Employment",proofOfEmployment),"Proof of Employment was not uploaded correctly");
        Assert.assertTrue(kycDocuments.isFileUploaded("Educational Document",educationalDocument),"Educational Document was not uploaded correctly");
        Assert.assertTrue(kycDocuments.isFileUploaded("Last Organisation Proof",lastOrganisationProof),"Last Organisation Proof was not uploaded correctly");
        Assert.assertTrue(kycDocuments.isFileUploaded("Aadhaar Card",aadhaarCard),"Aadhaar Card was not uploaded correctly");
        Assert.assertTrue(kycDocuments.isFileUploaded("PAN Card",panCard),"PAN Card was not uploaded correctly");
        Assert.assertTrue(kycDocuments.isFileUploaded("Bank Account Proof",bankAccountProof),"Bank Account Proof was not uploaded correctly");
    }
}
