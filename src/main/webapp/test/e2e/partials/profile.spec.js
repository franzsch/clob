describe("E2E: Profile", function() {

    beforeEach(function() {
        browser().navigateTo('/');
    });

    it('is profile available after login', function() {
    	 browser().navigateTo('#/login');
 		
         input('user.username').enter('Testperson2014');
         input('user.password').enter('Testperson2014');
        
         input('rememberMe').check();
         
         element('.btn-primary').click();  
        

        browser().navigateTo('#/profile');
        browser().navigateTo('#/profile');
        browser().reload();
           
                
        expect(element('.firstnameModel').html()).toBe('Max');
        
        expect(element('.lastnameModel').html()).toBe('Testperson');
        
        expect(element('.usernameModel').html()).toBe('Testperson2014');        
        
        expect(element('.emailModel').html()).toBe('testperson@adventurespots.com');
        
    });
    
});