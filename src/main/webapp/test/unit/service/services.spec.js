/**
 * 
 */

describe('Unittest Services', function() {
	
	var registerService;
	
	beforeEach(module('spotsAppServices'));
	
	beforeEach(inject(function (_registerService_) {
		registerService = _registerService_;
		
		 
	}));
	
	
  it('Password Equals', function() {
    expect(true).toBe(true);
    
    expect(registerService).toBeDefined();
    
    var user = {password:"Test", password1:"Test"};
        
    expect(registerService.checkPasswordEquals(user)).toBeDefined();
    
    expect(registerService.checkPasswordEquals(user)).toEqual(true);
       
    
  });
  
  it('Password Not Equals', function() {
	    expect(true).toBe(true);
	    
	    expect(registerService).toBeDefined();
	    
	    var user = {password:"Test1", password1:"Test"};
	        
	    expect(registerService.checkPasswordEquals(user)).toBeDefined();
	    
	    expect(registerService.checkPasswordEquals(user)).toEqual(false);
	       
	    
	  });
  
});