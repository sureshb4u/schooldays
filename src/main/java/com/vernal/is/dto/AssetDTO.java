/**
 * 
 */
package com.vernal.is.dto;

/**
 * @author bashelu
 *
 */
public class AssetDTO extends BaseDTO{

		private ParentDTO parent;
		private String externalId;
	    private String externalLink;
	    private DomainReferenceDTO assetType;
	    private DomainReferenceDTO contentType;
	   
		/**
		 * @return the parent
		 */
		public ParentDTO getParent() {
			return parent;
		}
		/**
		 * @param parent the parent to set
		 */
		public void setParent(ParentDTO parent) {
			this.parent = parent;
		}
		/**
		 * @return the externalId
		 */
		public String getExternalId() {
			return externalId;
		}
		/**
		 * @param externalId the externalId to set
		 */
		public void setExternalId(String externalId) {
			this.externalId = externalId;
		}
		/**
		 * @return the externalLink
		 */
		public String getExternalLink() {
			return externalLink;
		}
		/**
		 * @param externalLink the externalLink to set
		 */
		public void setExternalLink(String externalLink) {
			this.externalLink = externalLink;
		}
		/**
		 * @return the assetType
		 */
		public DomainReferenceDTO getAssetType() {
			return assetType;
		}
		/**
		 * @param assetType the assetType to set
		 */
		public void setAssetType(DomainReferenceDTO assetType) {
			this.assetType = assetType;
		}
		/**
		 * @return the contentType
		 */
		public DomainReferenceDTO getContentType() {
			return contentType;
		}
		/**
		 * @param contentType the contentType to set
		 */
		public void setContentType(DomainReferenceDTO contentType) {
			this.contentType = contentType;
		}
		   
    
    
    
}
